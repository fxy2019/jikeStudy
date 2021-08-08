package com.fxy.geekbang;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;


/**
 * 自定义class loader 
 * @author admin
 *
 */
public class MyClassLoader  extends ClassLoader{

	  public static void main(String[] args) throws Exception {
	  Object object=	new  MyClassLoader().findClass("Hello").newInstance();
	  Method method = object.getClass().getMethod("hello");
	  method.invoke(object);
	}
	
	public Class<?>  findClass(String  name){
		
		//需要解密  
		//1.从文件读取       
		File file  = new  File("C:\\Users\\admin\\Desktop\\zuoye\\Hello\\Hello.xlass");
		
		byte[] helloBytes=null;
		try {
			helloBytes = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] newHelloBytes = new byte[helloBytes.length];
		for (int i = 0; i < helloBytes.length; i++) {
			newHelloBytes[i] = (byte) (255-helloBytes[i]);
		}
		
		return defineClass(name, newHelloBytes, 0, newHelloBytes.length);
				
	}
 	
}
