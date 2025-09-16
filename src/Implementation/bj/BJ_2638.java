package Implementation.bj;
import java.util.*;
import java.io.*;
public class BJ_2638 {
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n  = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        graph = new int[n][m];


        //그래프 입력받기
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }

        //치즈 탐색
        int cnt = 0;
        while(true){
            if(!isCheese())break;
            //한사이클의 게임 진행할때마다 변수들 초기화
            visited = new boolean[n][m];
            dfs(0,0);//첫 좌표부터 탐색

            cnt++;
        }

        //결과 출력
        System.out.println(cnt);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0&& nx<n && ny<m && !visited[nx][ny]){ //0만 true로 변경할거야
                //치즈를 만났을 경우 ->체크
                if(graph[nx][ny] >=1){//숫자가 바뀌어서 2나3이 되어있을 수 있음(지우는건 한번에 삭제하지만 찾을때마다 갱신하기 때문에)
                    graph[nx][ny]+=1;//point : 실시간으로 graph의 내용을 변경하고 있음 따라서 ==1 이 아니라 >=1 이렇게 조건문에 달아야함
                }
                //공기를 만났을 경우 ->이동
                else if(graph[nx][ny] ==0){
                    dfs(nx, ny);
                }
            }
        }
    }
    public static boolean isCheese(){
        //3이상 적인 치즈들을 삭제
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(graph[i][j] >=3)
                    graph[i][j] = 0;//공기로 변환
                else if(graph[i][j] == 2)//한면만 닿았을 경우 다시 고쳐줌
                    graph[i][j] = 1;
            }
        }

        //치즈가 남아있는지 확인
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(graph[i][j]==1)
                    return true;//바로 반환 후 게임 재개
            }
        }


        //모든 좌표를 살폈는데도 치즈가 없을 경우 종료
        return false;
    }
}
