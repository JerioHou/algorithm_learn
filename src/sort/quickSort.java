package sort;

/**
 * 快速排序
 */
public class quickSort {

    public static void main(String[] args) {
        int len = 9999;
//        int len = 9;
        int arr[] = new int[len];
        while (len > 0) {
            arr[len-1] = (int) (Math.random()*len);
            len--;
        }
//        int arr[] = {2,10,8,22,5,34,12,28,21,11};
        long t = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis()-t);

        t = System.currentTimeMillis();
        quickSort2(arr,0,arr.length-1);
        System.out.println(System.currentTimeMillis()-t);
    }


    public static void quickSort2(int[] arr,int low,int high) {
        int p,i,j,temp;

        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }

            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }
            if(i == j) {
                break;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;
            i++;
        }
        if (i == j && arr[i] > p) {
             i--;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort2(arr,low,i-1);  //对左边快排
        quickSort2(arr,i+1,high); //对右边快排

    }

}
