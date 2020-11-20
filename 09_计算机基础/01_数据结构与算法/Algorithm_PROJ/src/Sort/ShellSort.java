package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        System.out.println("Shell sort...");
        System.out.println(Arrays.toString(arr));
        int[] resArr = shellSort(arr);
        System.out.println(Arrays.toString(resArr));
    }

    /*
    平均时间复杂度：O(n^1.3)
    最好时间复杂度：O(n)
    最坏时间复杂度：O(n^2)
    原理：
        对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列；
        所有距离为gap的倍数的记录放在同一个组中；然后，对各组内的元素进行直接插入排序。
        经上一步骤，每一组的元素都有序。
        减小gap的值，并重复执行上述的分组和排序。
        重复这样的操作，当gap=1时，整个数列就是有序的。
    */
    public static int[] shellSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
