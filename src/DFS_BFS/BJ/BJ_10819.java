package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class BJ_10819 {
    static int N;
    static boolean[] visited;
    static int[] output;
    static int[]A;
    static int max = -(int)1e9;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        output = new int[N];

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(max);

    }
    public static void perm(int depth){
        if(depth == N){
            /*점수 계산 후 최댓값 갱신*/
            cal();
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] =A[i];
                perm(depth+1);//연속 순서
                visited[i] = false;
            }
        }

    }
    public static void cal(){
        int sum = 0;
        /*output 계산*/
        for(int i = 0; i<N-1; i++){
            sum += Math.abs(output[i]-output[i+1]);//계산식
        }
        max = Math.max(max,sum);
    }
}
