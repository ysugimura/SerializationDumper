package com.cm55.deser.sample;

import java.io.*;

import com.cm55.deser.*;

public class Main {

  public static class Foo implements Serializable {
    Bar bar = new Bar();
    public class Bar implements Serializable {
      int value = 123;
    }
  }
  
  
  public static void main(String[]args) throws Exception {
    byte[]bytes;
    {
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      ObjectOutputStream objOut = new ObjectOutputStream(byteOut);    
      objOut.writeObject(new Foo());
      bytes = byteOut.toByteArray();
    }
    
    SerializationDumper sd = new SerializationDumper();
    sd.setBytes(bytes);
    sd.parseStream();
  }
}
