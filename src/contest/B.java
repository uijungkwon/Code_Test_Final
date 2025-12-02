package contest;
import java.util.*;
import java.io.*;
public class B { //38분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        /*음료수 종류와 개수 입력*/
        int[]A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());//인덱스 : 종류, 값: 개수
        }

        int max = -1;//초기화
        for(int i = 1; i<=N; i++){
            max = Math.max(max,A[i]);
        }//초기화

        /*동아리 부원 방문*/
        for(int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            //좋아하는 음료 번호
            int like = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());

            if(A[hate] == max) continue;
            else A[like]-=1;

            /*최대 음료수 개수 다시 찾기*/
            max = -1;
            for(int j = 1; j<=N; j++){
                max = Math.max(max,A[j]);
            }
        }
        /*정답 출력*/
        StringBuilder sb = new StringBuilder();
        for(int i= 1;i<=N; i++){
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb);

    }
}
