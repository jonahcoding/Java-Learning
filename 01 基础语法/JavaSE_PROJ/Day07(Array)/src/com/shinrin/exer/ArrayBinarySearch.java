package com.shinrin.exer;
//二分查找法
public class ArrayBinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,6,7,8,9,11,23,56};
		int value = 23;
		int left = 0;
		int right = arr.length-1;
		int mid = (left + right)/2;
		while(left < right) {
			if (value == arr[mid]) {
				System.out.println("Found " + value + ", index is " + mid);
				break;
			}else if (value < arr[mid]) {
				right = mid;
				mid = (left + right)/2;
			}else {
				left = mid;
				mid = (left + right)/2;
			}
		}
	}
}
