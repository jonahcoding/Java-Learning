package com.shinrin.java;
import org.junit.Test;
/*
 * 一、异常体系结构
 * 
 * java.lang.Throwable
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 * 		|-----java.lang.Exception:可以进行异常的处理
 * 			|------编译时异常(checked)
 * 					|-----IOException
 * 						|-----FileNotFoundException
 * 					|-----ClassNotFoundException
 * 			|------运行时异常(unchecked,RuntimeException)
 * 					|-----NullPointerException
 * 					|-----ArrayIndexOutOfBoundsException
 * 					|-----ClassCastException
 * 					|-----NumberFormatException
 * 					|-----InputMismatchException
 * 					|-----ArithmeticException
 * 
 */
public class ExceptionTest {

	@Test
	public void test(){
		String str = "abc";
		str = null;
		System.out.println(str.charAt(0));
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

}
