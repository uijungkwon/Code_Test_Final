package Implementation.bj;
import java.util.*;
import java.io.*;

public class BJ_12865 {
    static int n,k;
    static int[]w;
    static int[]v;
    static Integer[][] dp;
    static int max;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*물건의 개수와 최대 가방 무게 입력*/
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        /*n개만큼 각 물건의 무게와 가치 입력*/
        w = new int[n];
        v = new int[n];
        dp = new Integer[n][k+1];

        for(int i= 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        /*dp 테이블 함수 실행*/

        System.out.println(knapsack(n-1, k));//TopDown 방식
    }
    public static int knapsack(int i, int k){
        //i가 0 미만
        if( i <0)return 0;

        if(dp[i][k] == null){//탐색 하지 않은 경우
            if(w[i] <= k){
                dp[i][k] = Math.max(knapsack(i-1,k), knapsack(i-1,k-w[i])+v[i]);
            }
            else if(w[i]>k){
                dp[i][k] = knapsack(i-1,k);//그 전까지 값의 최댓값으로 물려 받음
            }


        }
        return dp[i][k];

    }
}
