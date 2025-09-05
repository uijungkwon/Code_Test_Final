package Implementation.bj;//1시간
import java.util.*;
import java.io.*;

public class BJ_14499 {
    static int n,m,x,y,k;
    static int[][] graph ;
    //상하좌우 이동 -> 1칸 씩만 이동
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    //주사위 모양을 두개의 배열로 나눠서 표기

    ///핵심 포인트 주사위 평면도를 2개의 배열로 나눠 표기했음
    static int[] col = new int[4];//가로 부분
    static int[] row = new int[4];//세로 부분
    //1번 자리가 정답(공통 부분)
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        //graph 입력받기
        for(int i= 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                graph[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        //테스트 시작
        st = new StringTokenizer(br.readLine());
        for(int tc = 0; tc<k; tc++){
            //dir 방향으로 1칸 이동(탐색하는게 아니라 차례에 맞춰 한번만 굴림//
            int dir = Integer.parseInt(st.nextToken())-1;//방향입력
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            //그래프 밖으로 나갈 경우 해당 명령 무시
            if(nx<0 || ny<0|| nx>=n || ny>=m) continue;

            //그래프 안에 있을 경우 방향에 맞춰 이동(주사위 위치는 즉시 갱신)
            x  = nx;
            y = ny;

            //dir에 맞춰 회전 진행
            change(dir);

            //회전 후 주사위 밑바닥 갱신
            if(graph[x][y] == 0)
                graph[x][y] = row[4-1];
            else{
                row[4-1] = graph[x][y];
                col[4-1] = graph[x][y];// 주사위 바닥면에 복사 및 갱신
                graph[x][y] = 0;
            }


            //결과 출력(항상 맨 윗자리)
            System.out.println(row[2-1]);
        }

    }
    public static void change(int dir){
        //핵심 포인트 2 -> 두개의 배열의 공통된 부분이 2번과 4번임
        //따라서 한배열이 변경된다면 다른 배열의 2번과 4번도 동시 변경 되어야함

        //방향에 맞춰 회전 먼저 진행 (동시에 갱신)
        if(dir == 0){//동쪽 회전//오른쪽
            int tmp = col[col.length-1];
            for(int i= col.length-1; i>0; i--){
                col[i] = col[i-1];
            }
            col[0] = tmp;

            row[1] = col[1];
            row[3] = col[3];// 동시 갱신
        }
        else if(dir == 1){//서쪽 회전 //왼쪽
            int tmp = col[0];
            for(int i= 0; i<col.length-1; i++){
                col[i] = col[i+1];
            }
            col[col.length-1] = tmp;

            row[1] = col[1];
            row[3] = col[3];// 동시 갱신
        }
        else if(dir == 2){//북쪽 회전 //오른쪽
            int tmp = row[row.length-1];
            for(int i= row.length-1; i>0; i--){
                row[i] = row[i-1];
            }
            row[0] = tmp;

            col[1] = row[1];
            col[3] = row[3];// 동시 갱신
        }
        else if(dir == 3){//남쪽 회전 //왼쪽
            int tmp = row[0];
            for(int i= 0; i<row.length-1; i++){
                row[i] = row[i+1];
            }
            row[row.length-1] = tmp;

            col[1] = row[1];
            col[3] = row[3];// 동시 갱신
        }

    }

}
