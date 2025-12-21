package DFS_BFS.BJ;
import java.util.*;
import java.io.*;

public class BJ_14501 {
    /**
     * 최대 이익 출력하기
     * */
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i = 1; i<=N; i++){//1일부터 시작
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());//소요 시간
            int p = Integer.parseInt(st.nextToken());//상담 비용

            T[i] = t; P[i] = p;
        }
        /*모든 하루 탐색 */
        int[]d = new int[N+1];//0으로 초기화
        for(int i=  1; i<=N; i++){
            //수식 생성
            if(i+T[i]-1 <=N){
                /*해당 날짜 최대이익 VS i-1*/
                d[i+T[i]-1] = Math.max(d[i+T[i]-1], d[i-1]+P[i]);
            }
            d[i] = Math.max(d[i], d[i-1]);
        }
        /*
        for(int i = 1; i<=N; i++){
            System.out.println("d["+i+"] = "+d[i]);
        }*/
        /*정답 출력*/
        System.out.println(d[N]);
    }
}
