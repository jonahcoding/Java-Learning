package Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        System.out.println("Select sort...");
        System.out.println(Arrays.toString(arr));
        int[] resArr = selectSort(arr);
        System.out.println(Arrays.toString(resArr));
    }

    /*
    平均时间复杂度：O(n^2)
    最好时间复杂度：O(n^2)
    最坏时间复杂度：O(n^2)
    原理：
        假设首元素为最小值并放入已排序数列，从未排序的数列中找到最小值并与假设的最小值交换位置；
        从剩余未排序的元素中继续寻找最小元素，放到已排序序列的末尾。
        以此类推，直到所有元素均排序完毕。
    */
    public static int[] selectSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
