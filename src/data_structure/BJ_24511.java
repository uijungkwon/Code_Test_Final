package data_structure;
import java.util.*;
import java.io.*;
public class BJ_24511 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        int[]A = new int[N];
        st  = new StringTokenizer(br.readLine());
        /*스택 or 큐 여부 입력*/
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[]B = new int[N];
        st  = new StringTokenizer(br.readLine());
        /*기준 원소 입력*/
        for(int i = 0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        /*큐만 탐색할 리스트 생성*/
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            if(A[i] == 0)
                dq.offerLast(B[i]);
        }

        /*M개의 숫자 삽입 및 탐색*/
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        /*중첩문을 없애야한다. */
        for(int i = 0; i<M; i++){
            int in = Integer.parseInt(st.nextToken());
            dq.offerFirst(in);
            sb.append(dq.pollLast()).append(" ");
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
