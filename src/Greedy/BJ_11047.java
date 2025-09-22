package Greedy;
import java.util.*;
import java.io.*;

public class BJ_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*동전 개수(N) , 가치(k)입력 , 단 동전의 개수는 무한대*/
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*동전의 가치가 k가 될 수 있도록 필요한 동전의 개수를 "최소"로 찾기*/
        int[] A = new int[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;//몫
        for(int i = N; i>=1; i--){

            if(A[i]<=K ){//아직 값이 클 때
                cnt += K/A[i];//몫
                K = K%A[i];//K값 갱신
            }

            if(K == 0)break;
        }

        System.out.println(cnt);
    }
}
