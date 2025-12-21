package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class BJ_14888 {
    static int min = (int)1e9;
    static int max = -(int)1e9;
    static int N;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*숫자의 개수*/
        N = Integer.parseInt(br.readLine());

        /*수열 입력*/
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        /*연산자 종류별 개수*/
        int[] oper = new int[4];//덧셈, 뺄셈, 곱셈, 나눗셈 순서
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4;i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,A[0],A,oper);

        /*연산자를 모두 사용하여 경우의 수 구함 */
        System.out.println(max);
        System.out.println(min);

    }
    public static void dfs(int depth, int sum, int[]A, int[]oper){
        if(depth == N-1){
            /*최대 최소 합 구하기*/
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        /*4종류의 연산 진행*/
        if(oper[0]>0){//덧셈
            oper[0]--;
            dfs(depth+1,sum+A[depth+1],A, oper);
            oper[0]++;
        }
        if(oper[1]>0){//뺄셈
            oper[1]--;
            dfs(depth+1,sum-A[depth+1],A, oper);
            oper[1]++;
        }
        if(oper[2]>0){//곱셈
            oper[2]--;
            dfs(depth+1,sum*A[depth+1],A, oper);
            oper[2]++;
        }
        if(oper[3]>0){//나눗셈
            oper[3]--;
            if(sum <0){
                int n = Math.abs(sum)/A[depth+1];
                dfs(depth+1,-n,A, oper);
            }
            else dfs(depth+1,sum/A[depth+1],A, oper);
            oper[3]++;
        }


    }
}
