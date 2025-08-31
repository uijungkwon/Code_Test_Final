package DFS_BFS.BJ;
import java.util.*;

public class BJ_10026 {
    static int n;//graph 크기 nxn
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;
    static char[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//그래프 크기

        graph = new char[n][n];
        visited = new boolean[n][n];//덩어리 탐색할 때

        //graph 입력 받기
        for(int i = 0; i< n; i++){
            String str = sc.next();
            for(int j = 0; j<n; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        //색깔 덩어리 확인하기- 정상인 탐색
        int cor_1 = 0;
        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j,0);//탐색 시작 좌표
                    cor_1++;
                }
            }
        }

        System.out.print(cor_1+" ");
        visited = new boolean[n][n];//초기화

        //색깔 덩어리 확인하기- 색맹인 탐색
        int cor_2 = 0;
        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j,1);//탐색 시작 좌표
                    cor_2++;
                }
            }
        }
        System.out.println(cor_2);


    }
    public static void dfs(int x, int y, int chk){//chk = 0: 정상, 1:비정상

        //상하좌우 탐색
        for(int i= 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(chk ==0){//정상인의 경우
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && graph[nx][ny] == graph[x][y]){
                    visited[nx][ny] = true;
                    dfs(nx,ny,chk);
                }
            }
            else{//색맹인의 경우
                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]){
                    if(graph[x][y] == 'R'){
                        if(graph[nx][ny]== 'R' || graph[nx][ny] == 'G'){
                            visited[nx][ny] = true;
                            dfs(nx,ny,chk);
                        }
                    }
                    else if(graph[x][y] == 'G'){
                        if(graph[nx][ny]== 'R' || graph[nx][ny] == 'G'){
                            visited[nx][ny] = true;
                            dfs(nx,ny,chk);
                        }
                    }
                    else if(graph[x][y] == 'B' && graph[nx][ny] == 'B'){
                        visited[nx][ny] = true;
                        dfs(nx,ny,chk);
                    }

                }
            }




        }
    }
}