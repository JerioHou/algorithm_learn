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
//        selectionSort(arr,arr.length);
        quickSort(arr,0,arr.length-1);
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
     *
     *  希尔排序是把记录按下标的一定增量分组，
     *  对每组使用直接插入排序算法排序；
     *  随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，
     *  整个文件恰被分成一组，算法便终止。
     * 空间复杂的 O(n)
     * 时间复杂度O(n²)
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

    /**
     *  快速排序
     *
     *  从数组中选取一个值作为基准值，然后将数组排序，等到一个下表 i ，使得下标i左侧的值 都小于基准值，右侧的值都大于基准值
     *  然后在 i 左侧 和 右侧的数组 重复执行该操作
      * @param a
     * @param p
     * @param r
     */
    public static void quickSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int partition = partition(a, p, r);
        quickSort(a,p,partition-1);
        quickSort(a,partition+1,r);
    }

    /**
     *  取数组末尾的值为基准值
     *  i 初始为最左侧的值，遍历数据，找到第一个小于基准值的数据，与i的值进行交换，i++，知道数组末尾
     *  此时 i 的值必大于基准值，将i的值与基准值交换
     *  则 i 左侧都小于基准值， i 右侧 都大于基准值
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = pivot;
        a[r] = tmp;
        return i;
    }

}
