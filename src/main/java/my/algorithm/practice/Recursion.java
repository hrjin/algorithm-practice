package my.algorithm.practice;

/**
 * @author hrjin
 * @version 1.0
 * @since 2020-01-17
 */
public class Recursion {
    public static void main(String[] args){
        int n = 4;
        int m = 18;
        //recursion01(n);

        //int result = recursion02(n);

        //int result = recursion03(n);

        //int result = recursion04(n, m);
        //System.out.println(result);

        //recursion05("hello");

        //recursion06(m);

        int [] data = new int[]{1,32,52,13,43};
        int length = data.length;
        //int result = recursion07(length, data);

        //int target = 3;
        //int result = recursion08(target, 0, length, data);

        //int result = recursion09(0, 4, data);

        int [] sortedData = new int[]{1,3,5,8,10};
        int result = recursion10(sortedData, 8, 0, 4);
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

    // 최대공약수 (ex. 8, 10)
    // 전제조건 : m >= n
    public static int recursion04(int n, int m) {
        if(m < n) {
            int tmp = m; m = n; n = tmp;
        }

        if(m%n == 0) {
            return n;
        }else{
            return recursion04(n, m%n);
        }
    }

    // 문자열 뒤집어 프린트하기 (ex. hello)
    public static void recursion05(String str) {
        if(str.length() == 0) {
            return;
        } else {
            recursion05(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    // 2진수로 변환
    public static void recursion06(int m) {
        if(m < 2) {
            System.out.print(m);
        } else {
            recursion06(m/2);
            System.out.print(m%2);
        }
    }

    // 배열의 합 구하기(data[0] + data[n-1])
    public static int recursion07(int n, int[] data) {
        if(n <= 0) {
            return 0;
        } else {
            System.out.println(data[n-1]);
            return recursion07(n-1, data) + data[n-1];
        }
    }

    // 순차 탐색(검색 구간의 시작 매개변수 명시적 선언 :: use 'begin' argument instead of 0)
    public static int recursion08(int target, int begin, int end, int[] data) {
        if(begin > end) {
            return -1;
        } else if(target == data[begin]){
            return begin;
        } else {
          return recursion08(target, begin + 1, end, data);
        }
    }

    // 최대값 찾기
    public static int recursion09(int begin, int end, int[] data) {
        if(begin == end) {
            return data[begin];
        } else {
            return Math.max(data[begin], recursion09(begin + 1, end, data));
        }
    }

    // 이진 검색(Binary Search) : 데이터가 정렬돼 있는 배열에서 특정한 값을 찾아내는 알고리즘이다. 배열의 중간에 있는 임의의 값을 선택하여 찾고자 하는 값 X와 비교한다.
    public static int recursion10(int[] data, int target, int begin, int end) {
        if(begin > end) {
            return -1;
        } else {
            int middle = (begin + end)/2;
            int compResult = data[middle];

            if(target == compResult) {
                return middle;
            } else if (compResult > target) {
                return recursion10(data, target, begin, middle-1);
            } else {
                return recursion10(data, target, middle + 1, end);
            }
        }
    }

}
