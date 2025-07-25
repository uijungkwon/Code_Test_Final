package DFS_BFS;//미로탈출 153p
import java.util.*;
class Node{
    int x;
    int y;
    int val;
    public Node(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class book_3 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;

    //이동 가능 범위 ; 상하좌우
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1) 미로 크기 입력 및 정보 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String str = sc.next();//공백 미 포함
            for(int j = 0; j<m; j++){
                map[i][j] = str.charAt(j);

            }
        }
        //2) 갈 수 있는 최소 칸의 개수 구하기(1이 있는 칸만 이동 가능)
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }
    public static void bfs(int x, int y){//출발위치(항상 0,0) -> 내 주변부 중심으로 탐색 -> 큐에 넣어서 탐색
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,1));
        visited[x][y] = true;

        while(!q.isEmpty()){//"최소"거리 찾기
            Node node = q.poll();

            for(int i = 0; i<4; i++){//이동가능 범위
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                int v = node.val;

                if(nx<0 || ny <0|| nx>=n|| ny>=m || map[nx][ny]==0 ||visited[nx][ny])continue;//탐색하지 않는 범위
                else{
                    q.offer(new Node(nx,ny,v+1));//첫 방문시에만 거리 기록(누적되면 최단거리가 아니니까)
                    visited[nx][ny] = true;
                    //탐색한 의미로 자기 차례까지 몇번 왔는지 확인
                    map[nx][ny] = v+1;//map에 자동으로 저장해서 "내가 원하는 위치" 까지 몇번만에 왔는지 확인!!
                    //System.out.println(nx+", "+ny+": "+(v+1));
                }
            }

        }
    }
}
