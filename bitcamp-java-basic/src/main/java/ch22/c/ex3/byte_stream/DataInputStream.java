package ch22.c.ex3.byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStream extends FileInputStream {

  public DataInputStream(String name) throws FileNotFoundException {
    super(name);
  }
  
  public int readInt() throws IOException {
    int value = 0;
    value |= read() << 24;
    value |= read() << 16;
    value |= read() << 8;
    value |= read();
    return value;
  }
  
  public short readShort() throws IOException {
    short value = 0;
    value |= read() << 8;
    value |= read();
    return value;
  }
  
  public long readLong() throws IOException {
    long value = 0;
    
    value |= (long) read() << 56;
    //System.out.println(Long.toHexString(value));
    value |= (long) read() << 48;
    //System.out.println(Long.toHexString(value));
    value |= (long) read() << 40;
    //System.out.println(Long.toHexString(value));
    value |= (long) read() << 32;
    //System.out.println(Long.toHexString(value));
    value |= (long) read() << 24;
    //System.out.println(Long.toHexString(value));
    value |= (long) read() << 16;
    //System.out.println(Long.toHexString(value));
    value |= (long) read() << 8;
    //System.out.println(Long.toHexString(value));
    value |= (long) read();
    //System.out.println(Long.toHexString(value));
    return value;
  }
  
  public boolean readBoolean() throws IOException {
    
    return read() == 1 ? true : false;
  }
  
  public String readUTF() throws IOException {
    // 먼저 UTF-8 바이트의 개수를 의미하는 2바이트를 읽음.
    int len = readShort();
    
    // 해당 개수 만큼 바이트 배열을 만듦.
    byte[] bytes = new byte[len];
    
    // 준비한 바이트 배열에 파일 데이터를 읽어 온다.
    read(bytes);
    
    // 읽어 온 바이트 배열을 가지고 String 객체를 만듦.
    return new String(bytes, "UTF-8");
    
  }
  
  
  
  
  
}
