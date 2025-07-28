package Shortest_Path;//미래도시
import java.io.*;
import java.util.*;
public class book_2 {
    static int n,m,k,x;
    static int[][]d;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) 회사개수(N)과 경로 개수(M)입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //2)거리 테이블 초기화
        d = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                d[i][j] = (int)1e9;
            }
        }

        ///경로 입력
        for(int i = 0; i<m; i++){//m개의 경로 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());//a<->b 이동 가능

            d[a][b] = 1;
            d[b][a] = 1;
        }

        //3) k번 회사, x번 회사를 입력
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //4) 1번 -> k번 -> x번  최단 이동 횟수 출력하기 // 플로이드 워셜 알고리즘 (1번부터 시작)
        for(int p = 1; p<=n; p++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){//i->p, p->j 이동
                    d[i][j] = Math.min(d[i][j], d[i][p]+d[p][j]);
                }
            }
        }

        //5) 정답 출력
        int result = d[1][k]+d[k][x];

        if(result >=(int)1e9)
            System.out.println(-1);
        else System.out.println(result);

    }


}
