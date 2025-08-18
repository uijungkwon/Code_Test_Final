package Dynamic;
import java.io.*;
import java.util.*;
public class test_33 {
    static int n;//남은 퇴사일
    static int[] T;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1) 퇴사 까지 남은 날 입력
        n = sc.nextInt();
        dp = new int[n+1];//dp 테이블 생성

        //2) 상담시간과 금액 입력
        T = new int[n];
        P = new int[n];
        for(int i = 0; i<n; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        //3) dp테이블 생성
        for (int i=0; i<n; i++) {
            if (i + T[i] <= n) {
                //날짜가 범위를 넘어가지 않는 경우
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]); //점화식 생성
            }
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        //4) 정답 출력
        int result = -1;
        for(int i = 0; i<=n; i++){
            result = Math.max(dp[i], result);
            System.out.println(dp[i]);
        }
        System.out.println("정답: "+ result);
    }
}
