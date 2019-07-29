// 버퍼 사용 - 버퍼를 적용하여 데이터 읽기를 대신 처리해주는 도우미 클래스 사용
//
package ch22.c.ex1.byte_stream;

public class Test01_3 {
  public static void main(String[] args) throws Exception {


    BufferedInputStream in = new BufferedInputStream("temp/jls12.pdf");


    System.out.println("데이터 읽는 중...");

    long start = System.currentTimeMillis();

    int b;
    int count = 0;
    while ((b = in.read()) != -1) {
      count++;
      // 겉으로는 1바이트씩 읽는 것 같다.
      // 그래서 1바이트를 암호화시키는 코드도 여기에 바로 작성하면 됨.
      // Test01_2.java에 비교하면 훨씬 편함.
      // 편하면서 동시에 읽기 속도도 빠르게 했다.
      // 어떻게?
      // => BufferdInputStream의 read() 메서드는 FileInputStream에서 상속 받은
      // 메서드를 이용하면 먼저 바이트 배열 단위로 데이터를 가져온 다음에
      // 그 배열에서 1바이트를 리턴함.
      // => 그 이후에 바이트 배열의 데이터가 떨어질 때까지 계속 바이트 배열에서
      // 값을 꺼내 리턴해 준다.
      // => 바이트 배열의 값이 떨어지면 다시 바이트 배열 단위로 데이터를 읽어 온다.
      // 그래서 1바이트씩 읽더라도 그렇게 속도가 떨어지지 않는 것.

      // 1바이트를 읽기 전 먼저 바이트 배열 단위로
      //
    }

    long end = System.currentTimeMillis();
    System.out.println(end - start);
    System.out.println(count); // 리드 호출. 1바이트씩 가져옴.
    System.out.println(in.count); // 버퍼드인풋은 실제 내부적으론 파일인풋 통해 버퍼를 409번 채워 넣음.
    in.close();


    System.out.println("출력 완료!");
  }
}


