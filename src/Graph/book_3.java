package Graph;// 도시 분할 계획 //크루스칼 알고리즘
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int a;
    int b;
    int c;
    public Node(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {//최소 먼저 선택
        return this.c - o.c;//비용
    }
}
public class book_3 {
    static int n,m;

    static int[] parent ;
    static Queue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args)throws Exception {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                //1) 집의 개수 (N), 길의 개수(M) 입력
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                parent = new int[n+1];
                for(int i = 0; i<=n; i++)
                    parent[i] = i;

                //2) M개의 간선과 비용 입력
                for(int i = 0; i<m; i++){
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());

                    pq.offer(new Node(a,b,c));
                }

                //3) 신장 그래프 찾기(크루스칼 알고리즘 사용하기)
                /*
                * //모든 노드 확인//최소 간선 먼저
                    //두 노드가 같은 부모를 가졌는지 확인
                    //같다면 사이클 -> continue, 같지 않다면 q에 포함하고 union 시킴
        //큐가 있는 모든 원소가 빠져나갈 때까지 실행
                *
                * */
                int cost = 0;//선택된 간선 비용의 합
                int max = -1;//간선의 최댓값
                while(!pq.isEmpty()){
                    Node node = pq.poll();
                    if(find(node.a) == find(node.b))continue;//같은 집합에 속해 있음//find로 찾아서 진행
                    else{
                        cost+=node.c;
                        union(node.a,node.b);
                        max = Math.max(max,node.c);
                    }
                }
                int result  = cost-max;
        System.out.println(result);

    }
    public static int find(int num){
        if(parent[num] == num)
            return num;
        else return parent[num] = find(parent[num]);
    }
    public static void union(int n1, int n2){
        int a = find(n1);
        int b = find(n2);
        if( a> b)parent[a] = b;
        else parent[b] = a;
    }
}
