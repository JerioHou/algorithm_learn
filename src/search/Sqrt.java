package search;


/**
 * 求一个数的平方根 精确到六位小数
 * 使用二分查找
 */
public class Sqrt {


    public static void main(String[] args) {
        System.out.println(Math.sqrt(13));
        System.out.println(sqrt2(13));
    }

    public static double sqrt2(int t) {

        if (t < 0) {
            throw new RuntimeException("Negative number cannot have a sqrt root.");
        }

        //先确定当前数所处的最小整数区间
        int i = 0;
        for ( ; i <= t; i++) {
            if (i * i == t) {
                return i;
            }
            if(i * i > t){
                break;
            }
        }

        //再通过二分法来进行判断检测
        double low = i-1, high = i, prec =  1e-15;
        double middle, squre;
        int count = 0;
        while (high - low > prec) {
            count++;
            middle = (low + high) / 2;
            squre = middle * middle;

            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        System.out.println("count = "+count);
        return (low + high) / 2;
    }

}
