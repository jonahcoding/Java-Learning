package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        System.out.println("Insert sort...");
        System.out.println(Arrays.toString(arr));
        int[] resArr = insertSort(arr);
        System.out.println(Arrays.toString(resArr));
    }

    /*
    平均时间复杂度：O(n^2)
    最好时间复杂度：O(n)，原始数组正序
    最坏时间复杂度：O(n^2)，原始数组反序
    原理：
        将待排序数组（n个元素）分为有序表和无序表，初始时有序表只包含一个元素，无序表包含其余n-1个元素。
        每次排序取出无序表中的第1个元素插入到有序表的适当位置。
        重复n-1次完成排序。
    */
    public static int[] insertSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}