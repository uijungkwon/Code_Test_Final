package DFS_BFS.BJ;
import java.util.*;
import java.io.*;

public class BJ1012 {
    static int n;//행
    static int m;//열
    static int k;//배추 개수
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;



        //테스트 케이스 시작
        for(int tc =0; tc<t; tc++ ){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int[n][m];
            visited = new boolean[n][m];

            //1)배추 위치 입력
            for(int i = 0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }

            //2) 지렁이 최소 위치 탐색
            int result= 0;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(!visited[i][j] && graph[i][j] == 1){
                        dfs(i,j);//하나의 덩어리를 끝까지 탐색
                        visited[i][j] = true;
                        result++;
                    }
                }
            }

            //3) 정답 출력
            System.out.println(result);
        }

    }
    public static void dfs(int x, int y){

        for(int i = 0; i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && graph[nx][ny]==1){
                visited[nx][ny] =true;
                dfs(nx, ny);
            }
        }

    }
}
