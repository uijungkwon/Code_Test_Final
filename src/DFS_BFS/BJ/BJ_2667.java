package DFS_BFS.BJ;
import java.util.*;

public class BJ_2667 {
    static int n;//graph 개수
    static ArrayList<Integer> list = new ArrayList<>();
    static int count;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;//주택 하나씩 탐색
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n][n];

        //graph 입력 받기
        for(int i = 0; i< n; i++){
            String str = sc.next();
            for(int j = 0; j<n; j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }

        //주택 단지 탐색하기
        int house = 0;//주택 단지 개수
        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    count = 1;
                    dfs(i, j);//탐색 시작 좌표
                    house++;
                    list.add(count);
                }
            }
        }
        System.out.println(house);
        Collections.sort(list);
        for(int i:list)
            System.out.println(i);
    }
    public static void dfs(int x, int y){

        //상하좌우 탐색
        for(int i= 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];


            if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && graph[nx][ny] == 1){
                visited[nx][ny] = true;
                count++;
                dfs(nx,ny);
            }


        }
    }
}
