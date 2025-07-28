package Dynamic;//217p_1로 만들기-> 연산 횟수의 최솟값 출력
import java.util.*;
public class book_2 {
    static int[] dp = new int[30001];//최소 연산 횟수를 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //바텀 업 방식으로 구하기
        dp[1] = 1;// 미리 초기화
        for(int i = 2; i<=num; i++){
            //-1 연산은 무조건 이뤄질 수 밖에 없음
            dp[i] = dp[i-1]+1;
            if( i%2 == 0)
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            if( i%3 == 0)
                dp[i] = Math.min(dp[i/3]+1, dp[i]);//2개씩 비교하도록 쪼갠 경우
            if( i%5 == 0)
                dp[i] = Math.min(dp[i/52]+1, dp[i]);

        }

        //정답 출력
        System.out.println(dp[num]);
    }
}