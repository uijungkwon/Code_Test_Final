package Implementation.bj;
import java.util.*;
import java.io.*;

class Index {
    int x;
    int y;
    int dust;//미세 먼지 값

    public Index(int x, int y, int dust){
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}
public class BJ_17144 {
    static int r,c,t;
    static int[][] graph;
    //미세먼지 위치 저장
    static Queue<Index> list = new LinkedList<>();
    //공기청정기 위치 저장
    static int clean_x = 0;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) r,c,t 입력
        r = Integer.parseInt(st.nextToken());//행
        c = Integer.parseInt(st.nextToken());//열
        t = Integer.parseInt(st.nextToken());//t초간 프로그램 작동
        graph = new int[r+1][c+1];

        //2) 그래프 값 입력(-1: 공기 청정기 위치)
        for(int i = 1; i<=r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=c; j++){
                int n = Integer.parseInt(st.nextToken());
                graph[i][j] = n;

                if(n != 0){
                    if(n == -1 && clean_x==0){//공기 청정기 위치(위)
                        clean_x = i;
                    }
                    //나머지는 미세먼지 위치 저장
                    list.add(new Index(i,j,n));

                }
            }
        }

        //3) t 초동안 탐색 시작-> 초당 한 칸 씩 이동
        for(int h = 1; h<=t; h++){
            //1. 미세먼지가 동시에 확산된다.
            bfs();
        }
        //3) 남아있는 미세먼지의 양을 출력한다.
        int result = check();

        //4) 결과 출력
        System.out.println(result);
    }
    public static void bfs(){
        //연관되어있는 곳 모두 탐색하는 것이아니라 1초당 1칸만 -> 내꺼 다 비우고 나서, 숫자있는것들을 새롭게 list에 추가하여 갱신

        while(!list.isEmpty()){//핵심 point: list안에 있는 값들은 변경되지 않음 !

            Index idx = list.poll();//미세먼지 리스트에서 하나의 미세먼지 꺼내기

            for(int i = 0; i<4; i++ ){//상하좌우 이동//기존값에서 계속 누적
                int nx = idx.x+dx[i];
                int ny = idx.y+dy[i];

                if(nx>0 && ny>0 && nx<=r && ny<=c && graph[nx][ny] !=-1 ){//확산이 일어날 수 있는 조건(한 칸당 최대 4개)
                    graph[idx.x][idx.y]  = graph[idx.x][idx.y]- (idx.dust/5);
                    graph[nx][ny] = graph[nx][ny]+(idx.dust/5);
                }

            }

        }

        //2. 확산이 끝났으면 공기청정기로 이동시킨다(첫번째 실수: list에 다 저장해놓고 이동하면 그 이동한 위치를 list에 갱신하지 못했던거였음! 함수 호출 순서를 유의하자)


        clean();

        //3. 끝났으면 바로 똑같이 list에 모두 넣어주기(갱신)
        for(int i = 1; i<=r; i++){
            for(int j = 1; j<=c; j++){
                if(graph[i][j] != -1 &&graph[i][j] !=0 ) {
                    list.offer(new Index(i, j, graph[i][j]));

                }
            }
        }

    }
    public static void clean(){// 회전 방향 회전도 90도각도로 꺾임 -> 이거를 방향대로 쪼개자! (어려울것같으면 쪼개자!)
            ////(위) -> 배열 원소이동 권법 사용 화살표는 4종류밖에 없음
            //아래방향
            for(int i = clean_x-1 ; i>1; i--){//1칸을 비워놓음
                graph[i][1] = graph[i-1][1];
            }
            //왼쪽 방향
            for(int i = 1 ; i<c; i++){
                graph[1][i] = graph[1][i+1];
            }
            //위 방향
            for(int i = 1 ; i< clean_x; i++){
                graph[i][c] = graph[i+1][c];
            }

            //오른쪽 방향??
            for(int i = c ; i>=3; i--){
                graph[clean_x][i] = graph[clean_x][i-1];
            }
            graph[clean_x][2] = 0;//gone;


            /////아래
            //위 방향
            for(int i =clean_x+2; i<r; i++){
                graph[i][1] = graph[i+1][1];
            }
            //왼쪽 방향
            for(int i = 1 ; i<c; i++){
                graph[r][i] = graph[r][i+1];
            }
            //아래 방향
            for(int i = r ; i>clean_x+1; i--){
                graph[i][c] = graph[i-1][c];
            }
            //오른쪽 방향
            for(int i = c ; i>=3; i--){
                graph[clean_x+1][i] = graph[clean_x+1][i-1];
            }
            graph[clean_x+1][2] = 0;//gone




    }
    public static int check(){
        int sum = 0;
        for(int i = 1; i<=r; i++){
            for(int j =1; j<=c; j++){
                if(graph[i][j] !=-1 && graph[i][j] !=0)
                    sum = sum + graph[i][j];
            }
        }
        return sum;
    }
}
