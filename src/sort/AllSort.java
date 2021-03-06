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
//        long t = System.currentTimeMillis();
////        selectionSort(arr,arr.length);
//        quickSort(arr,0,arr.length-1);
//        System.out.println("time = "+ (System.currentTimeMillis()-t));
//        System.out.println(Arrays.toString(arr));

        int k = 7;
        int kth = findKth(arr, 0, arr.length-1, k);
        System.out.println("第"+k+"大得值= "+ kth);
        quickSort(arr,0,arr.length-1);
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
     *  从数组中选取一个值作为基准值，然后将数组排序，得到一个下标 i ，使得下标i左侧的值 都小于基准值，右侧的值都大于基准值
     *  然后在 i 左侧 和 右侧的数组 重复执行该操作
      * @param a 数组
     * @param p 分割点
     * @param r 右侧终点
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
     *  i 初始为最左侧的值，遍历数据，找到第一个小于基准值的数据，与i的值进行交换，i++，直到数组末尾
     *  此时 i 的值必大于基准值，将i的值与基准值交换
     *  则 i 左侧都 < 基准值， i 右侧 都 >= 基准值
     * @param a
     * @param p
     * @param r
     * @return
     *
     */
    private static int partition(int[] a, int p, int r) {
        // 基准值
        int pivot = a[r];
        // i 记录的时比基准值大的坐标
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] <= pivot) {
                // 如果a[j]值小于等于基准值，就将两个下表的值交换
                // 则此时a[i]的值 小于基准值，i 右侧的值都大于等于基准值
                // i++后，i指向的值必大于基准值
                swap(a,i,j);
                i++;
            }
        }
        // 此时a[i]的值必大于基准值，交换后，i左侧的值比小于基准值
        // i 就是分割点
        swap(a,i,r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /**
     * 求第K大的元素
     *
     * 我们选择数组区间 A[0…n-1]的最后一个元素 A[n-1]作为 pivot，
     * 对数组 A[0…n-1]原地分区，这样数组就分成了三部分，A[0…p-1]、A[p]、A[p+1…n-1]。
     * 如果 p+1=K，那 A[p]就是要求解的元素；
     * 如果 K>p+1, 说明第 K 大元素出现在 A[p+1…n-1]区间，我们再按照上面的思路递归地在 A[p+1…n-1]这个区间内查找。
     * 同理，如果 K<p+1，那我们就在 A[0…p-1]区间查找。
     *
     */
    public static int findKth(int[] a,int l,int r,int k) {
        int partition = partition(a, l, r);
        if (partition == k -1) {
            return a[partition];
        }
        if (partition > k-1){
            return findKth(a,l,partition-1,k);
        } else {
            return findKth(a,partition+1,r,k);
        }
    }

    /**
     * 桶排序
     * 特征：
     * 首先，要排序的数据需要很容易就能划分成 m 个桶，并且，桶与桶之间有着天然的大小顺序。
     * 这样每个桶内的数据都排序完之后，桶与桶之间的数据不需要再进行排序。
     * 其次，数据在各个桶之间的分布是比较均匀的。
     * 如果数据经过桶的划分之后，有些桶里的数据非常多，有些非常少，很不平均，那桶内数据排序的时间复杂度就不是常量级了。
     * 在极端情况下，如果数据都被划分到一个桶里，那就退化为 O(nlogn) 的排序算法了。
     */

    /**
     * 如何根据年龄给100万用户数据排序？
     */

    /**
     * 10GB 的订单数据，按照金额排序，内存有限只有几百MB
     *
     * 思路：
     *
     */


    /**
     * 计数排序
     * 例如：从100万考生中获取某一个成绩的排名
     * 方法：假设总分为100分，创建一个长度101的数组，默认为0
     * 下标对应分数，值为该分数的人数
     * 遍历数组，将对应分数下表的值加1
     */

}
