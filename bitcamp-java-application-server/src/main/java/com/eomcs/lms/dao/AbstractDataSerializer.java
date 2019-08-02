package com.eomcs.lms.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class AbstractDataSerializer<T,K> {

  // 서브 클래스에서 저장된 데이터를 꺼내거나 조회할 수 있도록 하기 위해 접근 범위를 protected로 함.
  protected ArrayList<T> list = new ArrayList<>();
  
  // 내부에서만 사용할 필드고 외부에서도 사용해선 안 될 필드라 private로 함.
  private File file;
  
  public AbstractDataSerializer(String file) {
    this.file = new File(file);
  }
  
  @SuppressWarnings("unchecked")
  protected void loadData() throws IOException, ClassNotFoundException {
    try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream(file))) {
      list = (ArrayList<T>) in.readObject();  // T : 타입 정보를 담는 변수.
    }
  }

  protected void saveData() throws FileNotFoundException, IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream(file))) {
      out.writeObject(list);
    }
  }
  
  // 서브 클래스에서 특정 값을 가지고 데이터를 찾는 기능을 반드시 구현하도록 강제하자!
  public abstract int indexOf(K key);
  
  
}
