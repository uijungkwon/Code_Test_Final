package Implementation.bj;
import java.sql.Array;
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BJ_15683 {
    static int n,m;
    static int min = (int)1e9;
    static int[][] graph;
    static int[][] copy;
    static int[] output ;
    static List<Node> list = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = new int[]{-1,0,1,0}; //방향 : 북 동 남 서  (0,1,2,3)
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
                    list.add(new Node(i,j));
                }
            }
        }
        //탐색 시작
        //1) cctv 방향의 순열 찾기
        int k = list.size();//cctv의 개수
        output = new int[k];
        perm(0,k);

    }
    //가장 기초 : 순열로 인해 내가 원하는 조합 만들어 내기
    public static  void perm(int depth, int c){

    }
}
