package Dynamic;
import java.util.*;
import java.io.*;
public class test_34 {//최대로 긴 수열 찾기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] power = new int[n];

        for(int i= 0; i<n; i++){
            power[i] = sc.nextInt();
        }

        int[] dp = new int[n];//0번 부터 시작
        //dp 테이블 생성하기
        for(int i = 0; i<n; i++){
            dp[i] = 1;//내 자신 초기화
            for(int j = 0; j<i; j++){
                if(power[i] < power[j])//내림차순을 만족할 경우
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int result = -1;
        for(int i= 0; i<n; i++){
            result =Math.max(result, dp[i]);
        }
        System.out.println(n-result);
    }
}
