package Implementation;
import java.util.*;
import java.io.*;
//상하좌우 움직임 뿐만 아니라, 게임 캐릭터의 방향성 까지 고려해야하는 문제
public class book_3 {
    public static int n,m, direction,count;
    public static int[][] map;
    public static boolean[][]visited;
    public static int[] dx = new int[]{0,1,0,-1}; //상 우 하 좌
    public static int[] dy = new int[]{1,0,-1,0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1)맵의 크기 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];//0번부터 시작
        visited =new boolean[n][m];//메모리 최대 용량 //왔다 간 곳인지 체크

        //2) 게임 캐릭터 위치와 바라보는 방향 입력
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //3) 맵 정보 입력
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //4) 시뮬레이션 시작
        dfs(x,y,d);
        System.out.println(count);
    }
    public static void direc(int d){
        direction--;
        if(direction ==-1) direction = 3;
    }
    public static void dfs(int x, int y, int d){//캐릭터 "현재 좌표" 와 방향성
        visited[x][y] = true;
        //방문한 칸의 개수
        count = 1;
        int turn_time = 0;//방향을 회전한 횟수

        while(true){//방향은 움직인 위치로 고정되어야한다.-> 전역 변수
            direc(d);//모든 4가지 방향을 확인하는게 아니라 d방향으로 이동하는지 확인

            int nx = x+dx[direction];
            int ny = y+dy[direction];

            //이동성의 문제

            //가보지 않은 칸이 존재한다면
            if(visited[nx][ny] == false && map[nx][ny] == 0){
                visited[nx][ny] = true;
                count++;//방문한 한 칸
                turn_time = 0;//방문 완료했으니 더이상 돌지 않아도 ok

                //캐릭터의 현재 위치 재정의
                x = nx;
                y = ny;
                continue;
            }
            //모두 가봤거나 바다 인 경우//회전만 하고 반복문 진행
            else if(visited[nx][ny] || map[nx][ny] == 1){
                turn_time ++;//이동하지 않고 바라보는 방향을 바꾼다.
            }

            //4번 모두 회전했는데 갈 곳이 없는 경우 //맨 처음 방향으로 돌아옴
            if(turn_time == 4){//방향은 유지한 채로 뒤로 이동하기
                turn_time = 0;//초기화
                nx = x-dx[direction];//nx, ny는 임의의 위치
                ny = y-dy[direction];

                if(map[nx][ny] == 1)break;//뒤로 이동했는데 바다라면 멈추기
                else {//갈 수 있으면 이동하기
                    x = nx;
                    y = ny;//캐릭터 현재 위치 갱신
                }

            }
        }
    }
}
