package Implementation.bj;
import java.util.*;
import java.io.*;

class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BJ_21610 {
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static List<Pos> list =new ArrayList<>();//클라우드의 위치만 넣기
    static int[]d;
    static int[]s;
    static  int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};//1번부터 8번까지 방향을 정해놨으니 (x,y) 바뀌는 상하좌우 이동처럼 편하게 변수 생성
    static  int[] dy = {-1, -1,  0,  1, 1, 1, 0, -1};//상하좌우 이동처럼 nx+dx[dir] 해당 방향대로 유지해서 s칸 이동하기
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        /*바구니 칸에 물 초기화*/
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());//물의 양
            }
        }

        /*d,s 방향과 이동 칸 수 입력 받기*/
        d = new int[m];
        s = new int[m];
        for(int i= 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            d[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        /*첫  4칸의 구름 생성*/

        list.add(new Pos(n,1));
        list.add(new Pos(n,2));
        list.add(new Pos(n-1,1));
        list.add(new Pos(n-1,2));



        /*m회 동안 게임 진행 */
        for(int i =0; i<m; i++){//칸마다 함수 진행
            /*1. 모든 구름이 d[i]방향으로 s[i]만큼 이동한다.*/
            move(d[i], s[i]);

            /*2. 구름이 있는 칸에 비가 1씩 내린 후 구름은 사라진다*/
            rain();

            /*3. 구름이 있는 대각선 방향에 물이 있다면, 존재하는 칸의 개수만큼 물의 양을 증가시킨다*/
            search();

            /*4.구름이 있었던 칸을 제외한 나머지 칸 중에서 물의 양이 2 이상인 칸에 구름 생성, 2만큼 물이 줄어든다*/
            making();

        }
        /*모든 이동이 끝난 후 물의 양 측정*/
        int result = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                result = result+graph[i][j];
            }
        }
        System.out.println(result);
    }
    public static void move(int d, int s){ //여기서 노가다 보드 효율적으로 규칙 넣어서 수정
        //d방향으로 s만큼 이동
            for(int i = 0; i<list.size(); i++){//규칙성
                Pos pos = list.get(i);
                int x = pos.x;
                int y = pos.y;

                if(d == 1){//x고정 y 왼쪽 방향
                    for(int j = 0; j<s; j++){
                        if(y==1)
                            y = n;
                        else y = y-1;
                    }
                }
                else if(d == 2){//왼쪽 위로 대각선
                    for(int j = 0; j<s; j++){
                        x = (x == 1) ? n : x - 1;
                        y = (y == 1) ? n : y - 1;
                    }
                }
                else if(d == 3){//위로
                    for(int j = 0; j<s; j++){
                        if(x==1)
                            x = n;
                        else x = x-1;
                    }
                }
                else if(d == 4){//오른쪽 위 대각선
                    for (int j = 0; j < s; j++) {
                        x = (x == 1) ? n : x - 1;
                        y = (y == n) ? 1 : y + 1; //새로운 좌표값 갱신 -> 실수 X
                    }
                }
                else if(d == 5){//오른쪽
                    for(int j = 0; j<s; j++){
                        if(y==n)
                            y = 1;
                        else y = y+1;
                    }
                }
                else if(d == 6){//오른쪽 대각선 아래
                    for (int j = 0; j < s; j++) {
                        x = (x == n) ? 1 : x + 1;
                        y = (y == n) ? 1 : y + 1;//자기것만 보고 서로 영향을 주지 않음
                    }

                }
                else if(d == 7){//아래로
                    for(int j = 0; j<s; j++){
                        if(x==n)
                            x = 1;
                        else x = x+1;
                    }
                }
                else{//8
                    for (int j = 0; j < s; j++) {
                        x = (x == n) ? 1 : x + 1;  // 각 x,y 좌표를 갱신함
                        y = (y == 1) ? n : y - 1;
                    }

                }

                list.set(i, new Pos(x,y));
            }

    }
    public static void rain(){
        for(int i = 0; i< list.size(); i++){
            Pos pos = list.get(i);
            graph[pos.x][pos.y]++;

        }

    }
    public static void search(){
        //구름 존재 하나씩 대각선 방향에 물 있는지 탐색(4가지 방향)-> 방향성에 중점을 둔 코드
        for(int i = 0; i< list.size(); i++){
            int cnt = 0;
            Pos pos = list.get(i);

            if(pos.x-1>0 && pos.y-1>0 && pos.x-1 <=n&& pos.y-1<=n && graph[pos.x-1][pos.y-1] >0)
                cnt++;
            if(pos.x-1>0 && pos.y+1>0 && pos.x-1 <=n&& pos.y+1<=n && graph[pos.x-1][pos.y+1] >0)
                cnt++;
            if(pos.x+1>0 && pos.y-1>0 && pos.x+1 <=n&& pos.y-1<=n && graph[pos.x+1][pos.y-1] >0)
                cnt++;
            if(pos.x+1>0 && pos.y+1>0 && pos.x+1 <=n&& pos.y+1<=n && graph[pos.x+1][pos.y+1] >0)
                cnt++;

            graph[pos.x][pos.y]+=cnt;
        }



    }
    public static void making(){
        /*기존 구름이 있던 자리를 체크 해놓는다*/
        visited = new boolean[n+1][n+1];
        for(int i = 0; i<list.size(); i++){
            Pos pos = list.get(i);
            if(!visited[pos.x][pos.y])
                visited[pos.x][pos.y] = true;

        }
        list.clear();//구름 삭제


        for(int i= 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(graph[i][j] >=2 && !visited[i][j]){
                    graph[i][j]-=2;
                    list.add(new Pos(i,j));//새로운 구름 위치 저장
                }
            }
        }


    }
}
