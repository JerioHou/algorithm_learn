package sort;

import java.util.Arrays;

public class AllSort {

    public static void main(String[] args) {
        int len = 19;
        int arr[] = new int[len];
        while (len > 0) {
            arr[len-1] = (int) (Math.random()*len);
            len--;
        }
        System.out.println(Arrays.toString(arr));
        long t = System.currentTimeMillis();
        selectionSort(arr,arr.length);
        System.out.println("time = "+ (System.currentTimeMillis()-t));
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 插入排序
     *
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束。
     *
     * 空间复杂的 O(1)
     * 时间复杂度O(n²)
     * @param a 数组
     * @param n 数组的长度
     */
    public static void insertionSort(int[] a,int n) {
        if (n <= 1)
            return;
        for (int i = 1; i< n;i++) {
            int tmp = a[i];
            int j = i-1;
            for (;j>=0;j--) {
                if (a[j] > tmp) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = tmp;
        }
    }

    /**
     *  选择排序
     *
     *  选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     *  但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     *
     * 空间复杂的 O(1)
     * 时间复杂度O(n²)
     * @param a 数组
     * @param n 数组的长度
     */
    public static void selectionSort(int[] a ,int n) {
        if (n <= 1)
            return;

        for (int i = 0; i< n-1;i++) {
            int minIndex = i;
            for (int j = i+1;j< n;j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int min = a[minIndex];
            a[minIndex] = a[i];
            a[i] = min;
        }
    }


    /**
     *  希尔排序
     * @param arr
     * @param length
     */
    public static void shellSort(int[] arr,int length) {
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    /**
     *  希尔排序
     * @param arr
     * @param length
     */
    public static void shellSort2(int[] arr,int length) {
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                if (j+step != i) {
                    arr[j + step] = temp;
                }
            }
        }
    }
}
