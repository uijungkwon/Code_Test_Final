package DFS_BFS.BJ;//되돌리기 권법!!!
import java.util.*;
public class BJ_1987 {
    static int r,c;//행 열 크기
    static char[][] graph ;
    static boolean[] alpha;
    static int max = (int)-1e9;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        graph = new char[20][20];
        alpha = new boolean[27];//알파벳 체크(대문자 - 65)

        for(int i = 0; i<r; i++){
            String str = sc.next();
            for(int j = 0; j<c; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        //알파벳 탐색(0,0)부터 탐색 시작
        alpha[graph[0][0]-65] = true;//출발 지점 초기화
        dfs(0,0, 1);

        //정답 출력
        System.out.println(max);

    }
    public static void dfs(int x, int y, int cnt){//cnt가 max될 순간을 찾아야한다 HOW?
        //카운트 max로 업데이트
        if(alpha[graph[x][y]-65])
            max = Math.max(max,cnt);

        for(int i= 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0  && ny>=0 && nx<r && ny<c && !alpha[graph[nx][ny]-65]){
                alpha[graph[nx][ny]-65] = true;
                dfs(nx, ny, cnt+1);
                alpha[graph[nx][ny]-65] = false;//하나만 깊게 뚫고가는 경우 X -> "최장" 의 거리를 찾기 위해 경로(순서) 고려 재귀 밑에 원상복구
            }

        }
    }
}
