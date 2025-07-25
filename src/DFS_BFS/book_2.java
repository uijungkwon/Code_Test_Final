package DFS_BFS;
import java.util.*;
public class book_2 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    //이동 범위 : 상하좌우
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //1) 얼음틀의 크기와 정보를 입력한다.(n X m)

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String str=  sc.next();
            for(int j = 0; j<m; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        //2) 아이스크림 개수 구하기(0,0) 위치에서 탐색 시작 한다고 가정 (덩어리 개수 구하기)

        int result = 0;

        for(int i= 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && map[i][j] == 0){//덩어리 끝을 만날 때까지 탐색 시작
                    visited[i][j] = true;// 방문 처리
                    dfs(i,j);//덩어리 끝까지 찾기
                    result++;
                }
            }
        }

        System.out.println(result);
    }
    public static void dfs(int x, int y){//현재 위치

        //상하좌우 방향으로 탐색
        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=n || ny<0|| ny>=m || visited[nx][ny] || map[nx][ny] == 1)continue;//탐색 못하는 경우
            else{
                visited[nx][ny] = true;
                dfs(nx,ny);//재귀로 실행
            }

        }
    }
}
