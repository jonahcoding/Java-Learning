package com.shinrin.exer;
/*
--------------------
数组的反转：
--------------------
*/
public class ArrayReverse {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		System.out.print("数组反转：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
