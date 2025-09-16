package Implementation.bj;
import java.util.*;
import java.io.*;
class IDX {
    int x;
    int y;
    public IDX(int x, int y){
        this.x = x;
        this.y = y;
    }


}
public class BJ_2636 {
    static int n,m, cheese;
    static int[][] graph;
    static int[][] copy;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n  = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        //그래프 입력받기
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }
        //테두리 전체 탐색(가장 자리는 치즈가 올 수 없다)
        int cnt = 0;
        while(true){//치즈가 위에 있는 동안 게임 계속 진행
            if(!isCheese())break;
            //게임 진행할때 마다 boolean 초기화(copy본 안쓰니까), graph는 유지 치즈가 깎인 상태에서 진행하니까 boolean만 수정함
            visited = new boolean[n][m];

            visited[0][0] = true;
            cheese = 0; //치즈 개수는 갱신하지만 계속 초기화되어서 마지막 개수만 남게된다.
            dfs(0,0);

            cnt++;//게임 진행 횟수를 나타냄
        }
        System.out.println(cnt);
        System.out.println(cheese);
    }
    //치즈 내에 있는 구멍 상관없이 1의 주변에 있는 0들을 true로 바꿀 경우
    public static void dfs(int x, int y){

        for(int i= 0; i<4 ; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]){//조건에 맞을때만 재귀문 작성
                visited[nx][ny] = true; //치즈이건 공기건 탐색하면 boolean으로 확인함 -> 한번 체크한 놈은 안 건드려야하니까!
                if(graph[nx][ny] == 1){
                    graph[nx][ny] = 8;//녹아버릴 치즈라는 의미//변경해서 태울 값임을 시각화
                    //녹아버릴 치즈 개수
                    cheese++;
                    //완전 사소한 디테일 :1일땐 이동하지 않고 녹이는 치즈 개수 정보만 저장해주고 이동ㅇ안함!
                }
                else dfs(nx, ny);//0일 경우에만 재귀함수 호출해서 이동하는 거임!!!!!-> 이게 핵심 포인트
                //조건문으로 공기일때만 이동하기 그러니까 안으로 안들어감

            }
        }

    }
    public static boolean isCheese(){//치즈를 지울 때

        //graph[i][j] = 8로 표시된 부분은 공기로 변경해줘야함 -> 공기 변경 단계
        for(int i = 0; i< n ; i++){
            for(int j = 0; j<m; j++){
                if(graph[i][j] == 8) graph[i][j] = 0;//공기로 변경
            }
        }

        //판 위에 치즈가 아직 남아있는지 체크-> 게임을 더 진행할지 판단
        for(int i = 0; i< n ; i++){
            for(int j = 0; j<m; j++){
                if(graph[i][j] == 1) return true;
            }
        }
        return false;//이제 치즈가 없단 의미
    }
}
