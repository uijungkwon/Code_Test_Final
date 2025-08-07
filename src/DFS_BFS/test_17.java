package DFS_BFS;
import java.util.*;
import java.io.*;

class Node2 implements Comparable<Node2>{
    int x;
    int y;
    int v;//바이러스
    int t;//시간
    public Node2(int x, int y, int v, int t){
        this.x = x;
        this.y = y;
        this.v = v;
        this.t = t;
    }

    @Override
    public int compareTo(Node2 o) {
        if(this.t == o.t){//같은 그룹 안에 있을 경우
            return this.v- o.v;//바이러스 번호를 오름차순으로 정렬
        }
        return this.t - o.t;//시간 기준 오름차순
    }
}
public class test_17 {
    static int n,k,s,x,y;
    static int[][]map;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static Queue<Node2> q = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) n,k를 입력 받는다.
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //2) map을 입력 받는다.
        map = new int[n+1][n+1];//(1,1)부터 시작
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=n; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                q.offer(new Node2(i,j,num,0));///큐 초기화 -> 처음 입력된 바이러스 위치를 추가한다.(첫 시기는 0)
            }
        }
        //2) S,X,Y를 입력 받는다.
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        //4) S초 만큼 바이러스가 퍼지는 것을 확인한다.
        bfs(0);
        if(map[x][y] == 0) System.out.println(0);
        else System.out.println(map[x][y]);

    }
    public static void bfs(int t){
        //첫번째 원소 출력
        int cnt = 0;
        while(t < s){

            Node2 node = q.poll();
            int x = node.x;
            int y = node.y;
            int v = node.v;
            t = node.t;

            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<=0 || ny<=0 || nx>n||ny>n||map[nx][ny] !=0) continue;//테두리 바깥으로 나갈 경우
                else{
                    map[nx][ny] = v;
                    q.offer(new Node2(nx,ny,v,t+1));
                }
            }


        }

    }

}
