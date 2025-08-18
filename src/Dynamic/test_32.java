package Dynamic;
import java.util.*;
import java.io.*;
public class test_32 {
    static int n;
    static int[][] table;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1) 삼각형 크기 입력
        n = sc.nextInt();

        //2) table 생성 및 dp 테이블 초기화
        table = new int[n][n];
        dp = new int[500][500];

        for(int i = 0 ; i< n; i++){
            for(int j = 0; j<=i; j++){
                table[i][j] = sc.nextInt();
            }
        }

        //3) dp 테이블 생성하기
        dp[0][0] = table[0][0];//첫번째 원소 초기화
        for(int i = 1 ; i< n; i++){
            for(int j = 0; j<=i; j++){
                //원소가 테두리에 있을 경우
                if(j ==0){
                    dp[i][j] = dp[i-1][j]+table[i][j];
                }
                else if(j == n-1){
                    dp[i][j] = dp[i-1][j-1]+table[i][j];
                }

                //원소가 내부에 있을 경우
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+table[i][j], dp[i-1][j]+table[i][j]);

                }

            }
        }

        //4) 정답 출력
        int result = 0;
        //마지막 줄에서 최댓값 출력
        for(int i = 0; i<n; i++){
            result = Math.max(result, dp[n-1][i]);
        }
        System.out.println(result);
    }
}
