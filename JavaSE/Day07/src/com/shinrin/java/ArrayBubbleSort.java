package com.shinrin.java;
//冒泡排序
public class ArrayBubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[10];
		System.out.println("打印数组元素：");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(99-10+1)+10);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
