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

        //int [] data = new int[]{1,32,52,13,43};
        //int length = data.length;
        //int result = recursion07(length, data);

        //int target = 3;
        //int result = recursion08(target, 0, length, data);

        //int result = recursion09(0, 4, data);

        //int [] sortedData = new int[]{1,3,5,8,10};
        //int result = recursion10(sortedData, 8, 0, 4);

        boolean result =  findPath(0, 2);
        System.out.println("끝");
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

    public static boolean findPath(int x, int y) {
        // 미로
        int N = 5;
        int [][] maze = new int[N][N];

        // 랜덤하게 길 설정
        for(int i=1; i < N; i++) {
            for(int j=1; j < N; j++){
                //Math.random()값이 0.XXXXX로 나오기 때문에 10을 곱하여 이 값중 5보다 크면
                //1을 할당하고 작으면 0을 할당합니다..이렇게 함으로서 0,1만 출력 가능합니다.
                if(Math.random()*10 > 5)
                    maze[i][j] = 1;
                else
                    maze[i][j] = 0;
            }
        }

        // 1) 기본 설정
        int road = 0;
        int blocked = 2; // visited 이지만 출구 가는 길이 없음.
        int passRoad = 3; // visited 이고 출구 가는 방향이 있음.

        if(x < 0 || y < 0 || x >= N || y >=N) {
            return false;
        } else if (maze[x][y] != road) { // 벽, 막힌 길
            System.out.println("1 :: " + maze[x][y]);
            return false;
        } else if(x == N-1 && y == N-1){ // 출구
            maze[x][y] = passRoad;
            System.out.println("2 :: " + maze[x][y]);
            return true;
        } else {
            maze[x][y] = passRoad;
            System.out.println("3 :: " + maze[x][y]);
            // 상(x, y-1), 하(x, y+1), 좌(x-1, y), 우(x+1, y)
            if(findPath(x-1, y) || findPath(x+1, y) || findPath(x, y-1) || findPath(x, y+1)){
                return true;
            }
            maze[x][y] = blocked;
            return false;
        }


    }


    // blob 수 구하기(인접한 픽셀 수)
    public static int BACKGROUND_COLOR = 0;
    public static int IMAGE_COLOR = 1;
    public static int ALREADY_COUNTED = 2;

    public int countCells(int x, int y) {
        int N = 5;
        int[][] grid = new int[N][N];

        if(x < 0 || x >= N || y < 0 || y >= N)
            return 0;
        else if(grid[x][y] != IMAGE_COLOR)
            return 0;
        else {
            grid[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x-1, y+1) + countCells(x, y+1)
                    + countCells(x+1, y+1) + countCells(x-1, y)
                    + countCells(x+1, y) + countCells(x-1, y-1)
                    + countCells(x, y-1)+ countCells(x+1, y-1);
        }
    }
}
