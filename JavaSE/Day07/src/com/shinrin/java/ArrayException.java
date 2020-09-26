package com.shinrin.java;
/*
--------------------
Array常见异常：
	1.下标越界
	2.空指针
  
--------------------
 */
public class ArrayException {
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {0,1,2};
//		System.out.println("arr1[3] = " + arr1[3]); //java.lang.ArrayIndexOutOfBoundsException
		
		int[] arr2 = null;
//		System.out.println("Size of arr2 = " + arr2.length); //java.lang.NullPointerException
	}
}
