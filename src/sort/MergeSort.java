package sort;

/**
 *  归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int len = 1999999;
        int arr[] = new int[len];
        while (len > 0) {
            arr[len-1] = (int) (Math.random()*len);
            len--;
        }
//        int[] arr = {2,10,8,22,5,34,12,28,21,11};
        long t = System.currentTimeMillis();
        merge_sort(arr);
        System.out.println(System.currentTimeMillis()-t);
    }

    /**
     * 递归版：
     * @param arr
     * @param result
     * @param start
     * @param end
     */
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }


}
