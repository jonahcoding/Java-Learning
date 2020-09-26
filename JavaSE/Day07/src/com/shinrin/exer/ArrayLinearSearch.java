package com.shinrin.exer;
//线性查找
public class ArrayLinearSearch {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,4,5};
		int value = 5;
		
		for (int i = 0; i < arr.length; i++) {
			if (value == arr[i]) {
				System.out.println("Found " + value + ", index is " + i);
			}
		}
	}

}
