package com.shinrin.java;

import java.util.Arrays;

/*
--------------------
Array工具类常用方法：
	1.Arrays.equals(arr1, arr2));	判断数组相等
	2.Arrays.toString(arr1));		遍历数组
	3.Arrays.fill(arr3, 10);		数组填充
	4.Arrays.sort(arr4);			数组排序
	5.Arrays.binarySearch(arr4, 6)	二分查找
  
--------------------
 */

public class ArraysUtil {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3};
		int[] arr2 = new int[] {1,2,3};
		int[] arr3 = arr1;
		int[] arr4 = new int[] {3,6,1,7,4};
		//判断数组相等
		System.out.println("arr1 = arr2 ：" + Arrays.equals(arr1, arr2));//true
		System.out.println("arr1 = arr3 ：" + Arrays.equals(arr1, arr3));//true
		//遍历数组
		System.out.println("遍历数组arr1：" + Arrays.toString(arr1));
		//数组填充
		Arrays.fill(arr3, 10);
		System.out.println("arr3填充10，遍历数组：" + Arrays.toString(arr3));
		//数组元素排序（快排实现）
		Arrays.sort(arr4);
		System.out.println("arr4排序，遍历数组：" + Arrays.toString(arr4));
		//二分查找（返回索引，未找到返回负数）
		System.out.println("arr4二分查找6: "+ Arrays.binarySearch(arr4, 6));

	}
}
