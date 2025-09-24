package BackTrack;

import java.util.Scanner;

public class BJ_9663 {
    static int N;
    static int count;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        dfs(0);
        System.out.println(count);

    }
    public static void dfs(int depth){//퀸을 뽑는 알고리즘(조합 알고리즘)
        /*재귀 종료 조건-N개의 퀸을 다 뽑았을 때 */
        if(depth == N){
            count++;//경우의 수 누적
            return;
        }
        for(int i = 0; i<N; i++){
            arr[depth] = i;
            /*퀸을 놓을 수 있는지 확인 후 놓을 수 있으면 자리 확보 하고 재귀 호출, 아니라면 for문을 계속 돌아서 arr값 갱신 */
            if(check(depth))
                dfs(depth+1);//재귀 호출
        }


    }
    public static boolean check(int depth){//depth가 2라면, 2번째 행의 값을 구하고 싶은 것임

        for(int i = 0; i<depth; i++){
            if(arr[i]== arr[depth]){
                /*행이 서로 다른데, 같은 열이라면 조건 어긋남 */
                return false;
            }
            else if(Math.abs(i-depth)== Math.abs(arr[i]-arr[depth])){
                /*이말은 대각선에 존재한다는 의미, 그러면 조건에 어긋남*/
                return false;
            }
        }
        /*모두 통과하면 합격*/
        return true;

    }
}
