package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        System.out.println("Bubble sort...");
        System.out.println(Arrays.toString(arr));
        int[] resArr = bubbleSort(arr);
        System.out.println(Arrays.toString(resArr));
    }

    /*
    平均时间复杂度：O(n^2)
    最好时间复杂度：O(n)，所有元素正序（从小到大），必须加入布尔值判断是否进行过交换。
    最坏时间复杂度：O(n^2)，所有元素反序
    原理：
        遍历若干次待排序的数列，每次遍历从前往后依次比较相邻两个数的大小；
        如果前者比后者大，则交换位置。一次遍历后，数组最大元素到达数列末尾。
        采用相同的方法再次遍历，将未排序序列中的最大元素放在已排序数列的前方。
        重复操作，直至整个数列都有序为止！
    */
    public static int[] bubbleSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        boolean didSwap;
        for (int i = 1; i < arr.length; i++) {
            didSwap = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    didSwap = true;
                }
            }
            if (false == didSwap){
                return arr;
            }
        }
        return arr;
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
