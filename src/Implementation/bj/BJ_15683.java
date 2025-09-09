package Implementation.bj;
import java.sql.Array;
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int num;
    public Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

public class BJ_15683 {
    static int n,m;
    static int min = (int)1e9;
    static int[][] graph;
    static int[][] copy;
    static int[] output ;
    static List<Node> list = new ArrayList<>();
    static int[] dx = new int[]{-1,0,1,0}; //방향 : 북 동 남 서  (0,1,2,3) -> 시계 방향 회전
    static int[] dy =new int[]{0,1,0,-1};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i= 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] !=0 && graph[i][j] !=6){//CCTV장소를 입력해둔다.
                    list.add(new Node(i,j,graph[i][j]));
                }
            }
        }
        //탐색 시작
        int k = list.size();// cctv의 개수
        output = new int[k];// cctv 방향성(상하좌우)의 조합
        perm(0,k);

        //결과출력
        System.out.println(min);

    }
    //이론: 중복 순열로 인해 내가 원하는 조합 만들어 내기
    public static  void perm(int depth, int k){
        //재귀 종료 조건(cctv개수만큼 뽑았을 때)
        if(depth == k){
            //1) 가상의 경로를 입힐 거니까 지도를 복사한다.
            copy = new int[n][m]; ///새로 갱신
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    copy[i][j] = graph[i][j];
                }
            }

            //2) k개의 cctv만큼 for문을 돌면서 각각 감시할 수 있는 경우의 수 구하기
            for(int i = 0; i< list.size(); i++){
                cctv(list.get(i), output[i]);
            }
            //3) 변경된 copy graph에서 0의 개수를 체크한다.
            int result = check();
            min = Math.min(min, result);//새롭게 갱신

            return;
        }
        //중복순열 공식처럼 k개만큼의 방향을 설정
        for(int i = 0; i<4; i++){//상하좌우 방향
            output[depth] = i;//(0,1,2,3)
            perm(depth+1, k);

        }
    }
    public static void cctv(Node cctv, int dir){//cctv 객체(위치, 번호) 와 방향성을 입력 받음
        int x = cctv.x;
        int y = cctv.y;
        int cctvNum = cctv.num;

        if(cctvNum == 1){
            if(dir == 0){//상
                watch(x,y,0);
            }
            else if(dir == 1){//좌
                watch(x,y,1);
            }
            else if(dir == 2){//하
                watch(x,y,2);
            }
            else if(dir == 3){//좌
                watch(x,y,3);
            }
        }
        else if(cctvNum == 2){
            if(dir == 0){//상하
                watch(x,y,0);
                watch(x,y,2);
            }
            else if(dir == 1){
                watch(x,y,1);
                watch(x,y,3);
            }
            else if(dir == 2){
                watch(x,y,2);
                watch(x,y,0);
            }
            else if(dir == 3){
                watch(x,y,3);
                watch(x,y,1);
            }

        }
        else if(cctvNum == 3){
            if(dir == 0){//상
                watch(x,y,0);
                watch(x,y,1);
            }
            else if(dir == 1){//우
                watch(x,y,1);
                watch(x,y,2);
            }
            else if(dir == 2){//하
                watch(x,y,2);
                watch(x,y,3);
            }
            else if(dir == 3){//좌
                watch(x,y,3);
                watch(x,y,0);
            }

        }
        else if(cctvNum == 4){//나올 수 있는 모든 모양의 경우의 수가 되도록 구성하기
            if(dir == 0){//상
                watch(x,y,0); //경로를 이동해서 직접 탐색
                watch(x,y,1);
                watch(x,y,3);
            }
            else if(dir == 1){//우
                watch(x,y,1); //경로를 이동해서 직접 탐색
                watch(x,y,0);
                watch(x,y,2);
            }
            else if(dir == 2){//하
                watch(x,y,2); //경로를 이동해서 직접 탐색
                watch(x,y,1);
                watch(x,y,3);
            }
            else if(dir == 3){//좌
                watch(x,y,3); //경로를 이동해서 직접 탐색
                watch(x,y,0);
                watch(x,y,2);
            }
        }
        else if(cctvNum == 5){//모든 방향 탐색
            watch(x,y,0); //경로를 이동해서 직접 탐색
            watch(x,y,1);
            watch(x,y,2);
            watch(x,y,3);
        }


    }
    public static void watch(int x, int y, int direction){//방향별로 탐색을 쪼개 놓음(진짜 탐색 코드)
        //논리: 벽을 만날 때까지 direction을 유지하며 한방향으로 탐색
        //x와 y는 탐색의 시작 위치가 된다.

        int nx = x+dx[direction];
        int ny = y+dy[direction];//방향은 유지

        while(nx>=0 && ny>=0 && nx <n && ny <m && copy[nx][ny]!=6){
            if(copy[nx][ny] == 0)
                copy[nx][ny] = -1;//확인했다는 의미
            nx = nx+dx[direction];
            ny = ny+dy[direction];//방향은 유지

            //cctv면 숫자 변경하지 않고 넘어감
        }

    }
    public static int check(){
        int count = 0;
        for(int i = 0;i<n; i++){
            for(int j = 0; j<m; j++){
                if(copy[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}
