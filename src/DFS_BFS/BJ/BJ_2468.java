package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class BJ_2468 {
    static int n;
    static int height = (int)-1e9;
    static int max = (int)-1e9;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//그래프 크기

        graph = new int[100][100];


        //그래프 입력 받기
        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                graph[i][j] = sc.nextInt();
                height = Math.max(height, graph[i][j]);//물의 높이 중 최댓값 찾기
            }
        }

        //탐색하기

        for(int k =height ; k>0; k--){
            int result = 0;
            visited = new boolean[100][100];

            //빗물의 높이가 k일때 잠기는 지역 확인하기
            for(int i = 0; i <n ; i++){
                for(int j = 0; j<n; j++){
                    if(graph[i][j]>=k && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i,j,k);//끝까지 한 덩어리 찾기
                        result++;
                    }

                }
            }
            max = Math.max(max, result);
        }

    //정답 출력
        System.out.println(max);
    }
    public static void dfs(int x, int y, int h){//cnt가 max될 순간을 찾아야한다 HOW?

        for(int i= 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0  && ny>=0 && nx<n && ny<n && !visited[nx][ny] && graph[nx][ny] >= h){
                visited[nx][ny] = true;
                dfs(nx,ny, h);
            }

        }
    }
}
