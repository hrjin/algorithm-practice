package my.algorithm.practice;

/**
 * @author hrjin
 * @version 1.0
 * @since 2020-01-17
 */
public class Recursion {
    public static void main(String[] args){
        int n = 4;
        //recursion01(n);
        //int result = recursion02(n);
        int result = recursion03(n);
        System.out.println(result);
    }

    public static void recursion01(int k) {
        if(k <= 0) {
            return;
        }else{
            System.out.println("Hello hrjin...");
            recursion01(k-1);
        }
    }

    // n까지의 합 구하기
    public static int recursion02(int k) {
        if(k == 0) {
            return 0;
        }else{
            return k + recursion02(k-1);
        }
    }

    // 피보나치 수열
    public static int recursion03(int k) {
        if(k < 2) {
            return k;
        }else{
            return recursion03(k-1) + recursion03(k-2);
        }
    }
}
