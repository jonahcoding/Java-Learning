package com.shinrin.exer;
/*
--------------------
数组的赋值与复制：
--------------------
*/
public class ArrayCopy {
	public static void main(String[] args) {
		int[] arr1;
		int[] arr2;
		arr1 = new int[]{2,3,5,7,11,13,17,19};
		//打印arr1
		System.out.print("arr1:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		//arr2拷贝arr1（拷贝地址值，指向同一个空间）
		arr2 = arr1;
		//修改arr2
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] *=2;
		}
		//打印arr2
		System.out.print("arr2:");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		//打印arr1
		System.out.print("arr1:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		int[] arr3 = new int[]{2,3,5,7,11,13,17,19};
		int[] arr4 = new int[arr3.length];
		
		for (int i = 0; i < arr3.length; i++) {
			arr4[i] = arr3[i];
		}
		//修改arr4
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] *=3;
		}
		System.out.print("arr4:");
		for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");
		}
		System.out.println();
		
		//打印arr3
		System.out.print("arr3:");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
	}
}
