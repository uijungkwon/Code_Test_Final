package DFS_BFS.BJ;

import java.util.Scanner;

public class BJ_17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[]dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        /*point : 수학식을 코드로 적기!*/
        for(int i = 2; i<=N; i++){//나의 숫자 N 될 때까지
            int min = (int)1e9;//최댓값 설정
            /*나보단 작지만 최대의 제곱근 찾기*/
            for(int j = 1;j *j<=i ;j++){
                min = Math.min(min, dp[i-j*j]+1);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);

    }
}
