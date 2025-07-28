package Dynamic;//
import java.util.*;

public class book_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N입력
        int n = sc.nextInt();
        //dp테이블 만들기
        int[] dp = new int[1000];
        dp[1] = 1;//점화식 : dp[i] = dp[i-1] + dp[i-1]*2
        dp[2] = 3;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2]*2;
        }

        System.out.println(dp[n]);

    }
}
