package com.eomcs.util;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.handler.Command;

// 자바 객체를 자동 생성해 관리하는 역할
// 1단계 : App 클래스에서 객체 생성 코드를 분리하기
// 2단계 : 특정 패키지의 클래스에 대해 인스턴스 생성하기
public class ApplicationContext {

  HashMap<String,Object> objPool = new HashMap<>();
  
  // 자동 생성할 클래스 정보 목록
  ArrayList<Class<?>> classes = new ArrayList<>();

  public ApplicationContext(String packageName) throws Exception {
    
    
    createSqlSessionFactory();
    createTransactionManager();
    createDao();
  
    // 파라미터에 주어진 패키지를 뒤져서 Command 인터페이스를 구현한 클래스를 찾는다.
    // => 패키지의 경로를 알아낸다.
    String packagePath = packageName.replace(".", "/");
    File fullPath = Resources.getResourceAsFile(packagePath);
    
    
    // => 찾은 클래스의 인스턴스를 생성한다.
    findCommandClass(fullPath, packageName);
    createCommand();//인스턴스생성가능한커맨드가 다 담김.
    
    System.out.println("생성된 객체들");
    Set<String> keySet = objPool.keySet();
    keySet.forEach(key -> {
      System.out.printf("%s : %s\n",
          key, objPool.get(key).getClass().getName()); 
      // 키를 꺼내 객체의 타입을 확인하고 그 이름을 확인.
    });
  }

  private void findCommandClass(File path, String packageName) {
    File[] files = path.listFiles((file) -> { // 디렉토리인지 하나씩 확인.
      if (file.isDirectory()) //모든디렉을 리턴.
        return true;
      
      if (file.getName().endsWith(".class") &&
          file.getName().indexOf('$') == -1)
        return true;
      
      return false;
    });  //=> 디렉, 점클 파일 정보만 배열에 담기게 됨.
    
    for (File f : files) {
      if (f.isDirectory()) {
        findCommandClass(f, packageName + "." + f.getName()); 
        //디렉토리면 계속 파고듦.
      } else { // 파일이면
        String className = String.format("%s.%s",
            packageName, f.getName().replace(".class", "")); //파일이름뒤점클삭제
        
        try {
          Class<?> clazz = Class.forName(className); //forName 메서드를 이용해 클래스를 로딩
          if (isCommand(clazz) && !Modifier.isAbstract(clazz.getModifiers())) { //커맨드 인터 구현한 것만 등록하고 && 추상클래스가 아닌 일반만.
            classes.add(clazz); //이를 클래스목록에 추가.
          }
          
        } catch (ClassNotFoundException e) {
          // 클래스를 로딩하다가 오류가 발생하면 무시한다.
          e.printStackTrace();
        }
      }
    } //==>커맨드 인터 구현한 것만 등록하고 && 추상클래스가 아닌 일반만.담김.
    
  }
  
  private boolean isCommand(Class<?> clazz) {
    Class<?>[] interfaces = clazz.getInterfaces(); //클래스가 구혀한 인터 목록 다 배열에 담김.
    for (Class<?> c : interfaces) {
      if (c == Command.class) {
         return true; // 커맨드만 리컨.
      }
    }
    return false;
  }

  
  private void createCommand() {
    for (Class<?> clazz : classes) { //클래스가져옴.
      // 기본 생성자가 있으면 그 생성자를 호출해 인스컨스를 만든다.
      try {
        Constructor<?> defaultConstructor = clazz.getConstructor();
        Command command = (Command) defaultConstructor.newInstance(); // 
        objPool.put(command.getCommandName(), command);
        continue;
      } catch (Exception e) {
      }
      
      // 다른 생성자 꺼내기(포토보드애드커맨드처럼 기본생성자가 없는 경우,,, 여기서 여러가지 다른 생성자는 고려하지 않음..너무 복잡해짐.)
      Constructor<?> constructor = clazz.getConstructors()[0];
      
      try {
        // 생성자의 파라미터 정보로 값을 준비한다.
        Parameter[] params =  constructor.getParameters();
        Object[] values = prepareParameterValues(params); //파라미터에들어갈정보를 배열로 만듦.
        
        
      // 준비된 값을 가지고 생성자를 통해 인스턴스를 생성한다.
       Command command = (Command) constructor.newInstance(values);
      objPool.put(command.getCommandName(), command);
      } catch (Exception e) {
      }
      
      }
    }
  
  
  private Object[] prepareParameterValues(Parameter[] params) {
    Object[] values = new Object[params.length]; //파라미터 개수와 같은 배열 준비.
    
    // 파라미터 타입에 해당하는 값을 objPool에서 찾는다.
    for (int i = 0; i <params.length; i++) {
         values[i] = getBean(params[i].getType()); // 파라타입(인트인지..)정보를 빈에게 넘김.
      }
    return values;
  }

  private Object getBean(Class<?> type) { //맞는 객체를 찾아냄.
    Iterator<?> values = objPool.values().iterator(); //보관소에있는걸모두꺼낼준비.
    
    while (values.hasNext()) {
      Object value = values.next();
      
      
      // 풀에서 꺼낸 객체의 타입의 타입이 일치하는지 검사.
      if (value.getClass() == type)
        return value; //찾으면 객체 리턴.
      
      // 풀에서 꺼낸 객체의 인터페이스가 일치하는지 검사.
      Class<?>[] interfaces = value.getClass().getInterfaces(); //값객체의인터목록을 배열에 담음.
      for (Class<?> c : interfaces) { //하나씩 찾음.
        if (c == type)
          return value;
      }
    }
    throw new RuntimeException("해당 타입의 빈을 찾을 수 없습니다.");
    /*걍 참고 형식. 여긴 안 쓰임.
    values.forEach(value -> {
      // 하고 싶은 일...
    });
    */
  }

  public Object getBean(String name) throws RuntimeException {
    Object obj = objPool.get(name);
    if (obj == null)
      throw new RuntimeException("해당 이름의 빈을 찾을 수 없습니다.");
    return obj;
  }


  public void addBean(String name, Object obj) {
    if (name == null || obj == null)
      return;

    objPool.put(name, obj);
  }

  
  
  private void createSqlSessionFactory() throws Exception {
    //Mybatis 갹체 준비
    InputStream inputStream = 
        Resources.getResourceAsStream(
            "com/eomcs/lms/conf/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryProxy(
        new SqlSessionFactoryBuilder().build(inputStream));
    objPool.put("sqlSessionFactory", sqlSessionFactory);
  }

  private void createTransactionManager() throws Exception {
    // 트랜잭션 관리자를 준비한다.
    PlatformTransactionManager txManager = 
        new PlatformTransactionManager(
            (SqlSessionFactory)objPool.get("sqlSessionFactory"));
    objPool.put("txManager", txManager);
    
  }


  private void createDao() throws Exception {

    // DAO 구현체 생성기를 준비한다.
    MybatisDaoFactory daoFactory = new MybatisDaoFactory(
        (SqlSessionFactory)objPool.get("sqlSessionFactory"));

    //데이터 처리 객체를 준비한다.
    objPool.put("boardDao", daoFactory.createDao(BoardDao.class));
    objPool.put("memberDao", daoFactory.createDao(MemberDao.class));
    objPool.put("lessonDao",daoFactory.createDao(LessonDao.class));
    objPool.put("photoboardDao",daoFactory.createDao(PhotoBoardDao.class));
    objPool.put("photoFileDao", daoFactory.createDao(PhotoFileDao.class));
  }
  
  
  
  
}






















