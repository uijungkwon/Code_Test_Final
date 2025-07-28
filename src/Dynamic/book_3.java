package Dynamic;//개미전사_221p
import java.util.*;
public class book_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //식량창고 개수(n)과 식량 수 입력 받기
        int n = sc.nextInt();
        int[] food = new int[n+1];

        int[]dp = new int[101];//임의상 1번 부터 숫자 시작(창고는 최대 100까지 가질 수 있음)
        for(int i= 1; i<=n; i++)
            food[i] = sc.nextInt();

        //약탈할 수 있는 식량의 최댓값을 구한다.인접한 창고의 식량은 가져갈 수 없다.
        dp[1]=food[1]; dp[2] =Math.max(food[1],food[2]);
        for(int i = 3; i<=n; i++){//해당 번호까지의 "최댓값" 구하기
            dp[i] = Math.max(dp[i-1], dp[i-2]+food[i]);//인접한것과 덧셈할 수 없으니, 새로운 최댓값을 찾던지 없으면 그 값 그대로 밀어오기
        }
        //정답 출력
        System.out.println(dp[n]);
    }
}
