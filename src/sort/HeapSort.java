package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1,4,2,2,5,6,7,3,7,9,4};
        int n = arr.length;
        heapSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }



    private static void heapSort(int[] arr,int n) {
        buildHeap(arr,n);
        for (int i = n-1; i >0; i--) {
            swap(arr, 0,i);
            heapify(arr,i,0);
        }
    }

    private static void buildHeap(int[] arr,int n) {
        for (int i = (n>>>1)-1; i >= 0; i--)  {
            heapify(arr,n,i);
        }
    }

    /**
     * 堆化： 讲数组值调整位置，最终符合堆的定义
     * 堆：
     *      堆是一个完全二叉树；
     *      堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
     *   对于节点坐标： x, 父节点： (x-1)/2  则左子节点 x * 2 + 1, 右子节点 x * 2 + 2
     *   arr: 目标数组
     *   n： 数组长度
     *   i:  当前需要比较的坐标
     */
    private static void heapify(int[] arr,int n, int i) {
        while (true) {
            // 负责节点中 最大的那个的坐标
            int maxPost = i;
            if (i * 2 + 1 < n && arr[i * 2 + 1] > arr[maxPost] ) {
                maxPost = i * 2 + 1;
            }
            if (i * 2 + 2 < n && arr[i * 2 + 2] > arr[maxPost]) {
                maxPost = i * 2 + 2;
            }
            if (maxPost == i) {
                break;
            }
            swap(arr,maxPost,i);
            i = maxPost;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
