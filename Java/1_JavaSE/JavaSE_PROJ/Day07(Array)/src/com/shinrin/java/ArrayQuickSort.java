package com.shinrin.java;
//快速排序
public class ArrayQuickSort {

    public static void main(String[] args) {

        int[] arr = new int[100000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(1000000000-1+1)+1);
        }

        QuickSort(arr);
    }

    public static void QuickSort(int[] arr) {
        quickSort(arr,0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int low = left, high = right, mid = (left+right)/2,datum;
            if (arr[mid] > arr[high]) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
            }
            if (arr[low] > arr[high]) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
            if (arr[mid] > arr[low]) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
            }
            datum = arr[low];
            while(low < high) {
                while(low < high && arr[high] >= datum)
                    high--;
                if(low < high)
                    arr[low++] = arr[high];
                while(low < high && arr[low] <= datum)
                    low++;
                if(low < high)
                    arr[high--] = arr[low];
            }
            arr[low] = datum;

            quickSort(arr, left, low-1);
            quickSort(arr, low+1, right);
        }
    }
}