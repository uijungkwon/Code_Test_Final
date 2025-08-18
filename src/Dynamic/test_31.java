package Dynamic;
import java.util.*;
import java.io.*;

public class test_31 {
    static int n,m;
    static int[][] table;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //테스트 시작
        for(int tc = 0; tc<T;tc++){
            //1) 테이블의 행과 열 입력
            n = sc.nextInt();
            m = sc.nextInt();
            table = new int[n+2][m+2];
            dp = new int[n+2][m+2]; //양쪽으로 확장

            //2) 금 크기 입력
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=m; j++){
                    table[i][j] = sc.nextInt();
                    dp[i][j] = table[i][j];

                }

            }
            //3)dp 테이블 생성하기
            for(int j = 2; j<=m; j++) {
                for (int i = 1; i <= n; i++) {
                    //table 범위를 벗어나는 경우
                    //if ((i - 1) <= 0 || (i + 1) > n) continue;

                    int num = table[i][j];
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + num, dp[i][j - 1] + num), dp[i + 1][j - 1] + num); //점화식
                }
            }

            //4)정답 출력
            int result = 0;
            for(int i = 1; i<=n; i++){
                result = Math.max(result, dp[i][m]);
            }
            System.out.println(result);


        }


    }
}
