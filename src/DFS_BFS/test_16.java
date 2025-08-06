package DFS_BFS;//연구소 //bfs와 dfs의 합작
import java.util.*;
import java.io.*;
public class test_16 {
    static int n,m;
    static int max = (int)-1e9;
    static int[][] map;
    static int[][] copy;
    static boolean[][] visited;
    static int count ;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) N,M 크기 입력
        n  = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //2) map 입력하기
        map = new int[n][m];
        visited = new boolean[n][m];
        copy = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;

            }
        }

        //3) 3개의 벽을 세울 수 있는 모든 경우의 수 파악하기
        dfs(0);
        System.out.println(max);

    }
    public static void dfs(int depth){ //모든 칸 탐색
        if(depth == 3){//벽은 3개만 세울 수 있음
            bfs();//바이러스 퍼뜨리기 (벽을 3개 세운 상태)
            return;//재귀 함수 끝내기
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;//끝까지 갔다가 되돌아옴
                }
            }
        }
    }
    public static void bfs(){//바이러스가 상하좌우로 퍼짐
        count = 0;
        Queue<int[]> virus = new LinkedList<>();
        //1) map에 있는 바이러스 위치를 큐 리스트에 넣기
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] ==2)
                    virus.offer(new int[]{i,j});
            }
        }
        //임의로 바이러스 주입할꺼니까 copy생성해서 바이러스 주입하기
        for(int i = 0; i<n; i++){
            copy[i] = map[i].clone();//배열 한 줄 씩 복사
        }
        //2)바이러스 위치 기준으로 1을 만날 때까지 상하 좌우로 퍼짐
        while(!virus.isEmpty()){
            int[] vir = virus.poll();
            int x = vir[0];
            int y = vir[1];

            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(0 <= nx && nx <n && 0<= ny && ny <m && copy[nx][ny] == 0){
                    copy[nx][ny] = 2;
                    virus.add(new int[]{nx,ny});
                }
            }

        }
        //안전한 영역  ->0 인 영역 개수로 세기
        for(int i= 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(copy[i][j]==0)
                    count++;
            }
        }
        max = Math.max(max, count);//최댓값 갱신하기

    }
}
