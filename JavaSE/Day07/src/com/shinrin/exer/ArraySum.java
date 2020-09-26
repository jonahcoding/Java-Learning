package com.shinrin.exer;

/*
--------------------
长度为10的一维数组：数据为随机二位数，求和
	
随机数的获取：
	求[10,99]：(int)(Math.random()*(99-10+1)+10)
--------------------
*/

public class ArraySum {

	public static void main(String[] args) {
		int[] arr = new int[10];
		System.out.println("打印数组元素：");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(99-10+1)+10);
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		int arrSum = arr[0];
		int maxValue = arr[0];
		int minValue = arr[0];
		double mean = 0.0;
		
		for (int i = 1; i < arr.length; i++) {
			arrSum+=arr[i];
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
			if (arr[i] < minValue) {
				minValue = arr[i];
			}
		}
		
		mean = arrSum/arr.length;
		
		System.out.println("Sum = " + arrSum);
		System.out.println("Max Value = " + maxValue);
		System.out.println("Min Value = " + minValue);
		System.out.println("Average Value = " + mean);
	}
}
