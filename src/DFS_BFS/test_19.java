package DFS_BFS;
import java.util.*;
import java.io.*;
public class test_19 {
    static int n;
    static int[] A;
    static int min = (int)1e9;
    static int max = (int)-1e9;
    static int[] oper = new int[4];//연산자는 순서대로 +,-,*,/ 위치 고정(개수만 입력)
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1) n입력
        n = Integer.parseInt(br.readLine());

        //2) 수열 A를 입력
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        //3)연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        //4) 연산자 _모든 경우의 수 계산
        dfs(0,A[0],1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int depth, int sum, int idx){//연산자
        //여기에 변수를 지정하면 재귀함수 호출 될 때마다 초기화 되니까 함수 호출 할 때 출력
        if(depth == n-1) {
            min = Math.min(min,sum);
            max = Math.max(max,sum);
            return;
        }
        //종류 별로 다르게 계산(연산자 종류가 다르기 때문이다.)
        //덧셈
        if(oper[0]>0){
            oper[0]--;
            dfs(depth+1,sum+A[idx], idx+1);
            oper[0]++;
        }
        //뺄셈
        if(oper[1]>0){
            oper[1]--;
            dfs(depth+1,sum-A[idx], idx+1);
            oper[1]++;
        }
        //곱셈
        if(oper[2]>0){
            oper[2]--;
            dfs(depth+1,sum*A[idx], idx+1);
            oper[2]++;
        }
        //나눗셈
        if(oper[3]>0){
            oper[3]--;
            dfs(depth+1,sum/A[idx], idx+1);
            oper[3]++;
        }
    }
}
