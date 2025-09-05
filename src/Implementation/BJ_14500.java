package Implementation; //dfs->상하좌우 개념으로 풀기!!
import java.util.*;
import java.io.*;
public class BJ_14500 {
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int max = (int)-1e9;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        //그래프 입력
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //테트로 미노 최대값 구하기
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                ///테트로미노 탐색
                //기준이 되는 자기자신은 true처리
                visited[i][j] = true;
                dfs(i,j,graph[i][j], 1);
                visited[i][j] = false; //호출 바로 밑에 회복 시키기
            }
        }


        //정답 출력
        System.out.println(max);
    }
    public static void dfs(int a, int b, int sum, int count){
        //테트로미노는 무조건 4칸 (4번이동)
        if(count == 4){
            max = Math.max(max,sum);
            return;
        }
        //상하좌우 탐색
        for(int i = 0; i<4; i++){
            int nx = a+dx[i];
            int ny = b+dy[i];

            if(nx<0 || ny <0|| nx >=n || ny >=m ) continue;

            if(!visited[nx][ny]){
                if(count == 2){//ㅗ모양 테트로미노 만들기 위한 경우
                    //자기 자신 칸에서 방점을 찍고 양옆으로 뻗어나갔다 오도록 설정!(여기서 킵 포인트)
                    visited[nx][ny] = true;
                    dfs(a,b,sum+graph[nx][ny], count+1);//내 제자리에 머무르기, 하지만 새로운 좌표값은 sum에 누적합
                    visited[nx][ny] = false;//모든 경우의 수를 다 만들거니까! (바로 밑에서 호출(
                }

                visited[nx][ny] = true;
                dfs(nx,ny,sum+graph[nx][ny], count+1);
                visited[nx][ny] = false;//모든 경우의 수를 다 만들거니까!

            }

        }

    }
}
