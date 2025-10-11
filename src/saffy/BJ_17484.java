package saffy;
import java.util.*;
import java.io.*;
//54분 //dfs문제
public class BJ_17484 {
    /*우주선 이동방향*/
    static int[] dx = new int[] {0,1,1,1};
    static int[] dy = new int[] {0,-1,0,1};
    static int[][] map;
    static int N,M;
    static int min = (int)1e9;
    //아래 방향으로만 이동하므로 check 배열 필요없음
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*그래프 크기 입력*/
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /*그래프에 연소 입력*/
        map = new int[N+1][M+1];//1번부터

        for(int i = 1;i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*그래프 탐색*/
        for(int i = 1; i<=M; i++) {
            dfs(0,1,i,0,map[1][i]);//1행에서 출발
        }

        /*정답 출력*/
        System.out.println(min);

    }

    public static void dfs(int depth,int x, int y,int dir, int sum) {//dir:이 전 방향
        /*재귀함수 종료조건*/
        if(depth == N-1) {
            min = Math.min(min, sum);//해당 경로까지 누적된 합
            return;
        }
        /*3가지 방향으로 탐색*/
        for(int i= 1; i<=3; i++) {
            if(dir == i) continue;//이전 방향으로 갈 수 없음
            //함수에서 sum을 정의하고 호출 OR 호출인자에 sum을 직접정의(되돌아가서 모든 경로를 탐색해야하니까)->depth+1이랑 원리 똑같음
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=1 && ny>=1 && nx<=N && ny<=M ) {//map안에 들어올 조건
                dfs(depth+1,nx,ny,i,sum+map[nx][ny]);//한단계 전 방향만 아니면 OK
            }
        }



    }

}
