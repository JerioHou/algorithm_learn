package sort;



/**
 *  希尔排序
 */
public class shellSort {

    public static void main(String[] args) {
        int length = 19999999;
        int[] arr = new int[length];
        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length); // 生成一个[0, 8000000) 数
            arr2[i] = (int) (Math.random() * length); // 生成一个[0, 8000000) 数
        }

        long t = System.currentTimeMillis();
        shellSort(arr);
        System.out.println(System.currentTimeMillis()-t);

        long t2 = System.currentTimeMillis();
        shellSort2(arr2);
        System.out.println(System.currentTimeMillis()-t2);

    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
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

    public static void shellSort2(int[] arr) {
        int length = arr.length;
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
