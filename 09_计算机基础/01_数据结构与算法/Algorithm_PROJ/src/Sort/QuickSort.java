package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        System.out.println("Quick sort...");
        System.out.println(Arrays.toString(arr));
        int[] resArr = quickSort(arr);
        System.out.println(Arrays.toString(resArr));
    }

    /*
    平均时间复杂度：O(nlog2n)
    最好时间复杂度：O(nlog2n)
    最坏时间复杂度：O(n^2)
    原理：
        选择首元素、中间元素、尾元素中的中间值作为基准并放置在数组首位。
        在左边界小于右边界的前提下：从右往左，寻找小于基准的元素，赋值给左索引位，同时左索引自加。
        在左边界小于右边界的前提下：从左往右，寻找大于基准的元素，赋值给右索引位，同时右索引自加。
        当左右索引相等时，基准值赋给左索引位。
        以左索引位为区分，分治递归。
    */
    public static int[] quickSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length-1);
    }

    public static int[] quickSort(int[] arr, int left, int right){
        if (left < right){
            int low = left;
            int high = right;
            int mid = (left+right)/2;
            int datum;
            if (arr[mid] > arr[high]){
                swap(arr, mid, high);
            }
            if (arr[low] > arr[high]){
                swap(arr, low, high);
            }
            if (arr[mid] > arr[low]){
                swap(arr, mid, low);
            }
            datum = arr[low];
            while (low < high){
                while (low<high && arr[high] >= datum){
                    high--;
                }
                if (low < high){
                    arr[low++] = arr[high];
                }
                while (low < high && arr[low] <= datum){
                    low++;
                }
                if (low < high){
                    arr[high--] = arr[low];
                }
            }
            arr[low] = datum;
            quickSort(arr, left, low-1);
            quickSort(arr, low+1, right);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
