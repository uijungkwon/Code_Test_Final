package Shortest_Path;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int idx;
    int time;
    public Node(int idx,int time){//time 제일 크게 포함
        this.idx = idx;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time -o.time;
    }
}
public class book_3 {
    static int n,m,c;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static Queue<Node> q = new PriorityQueue<>();
    static int[] d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) 도시개수 N,통로 개수 M,출발 도시 C 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //graph 와 d 테이블 초기화
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<Node>());
        }
        d = new int[30001];
        for(int i = 0; i<=n; i++)
            d[i] = (int)1e9;
        d[c] = 0;//출발노드(c)는 0으로 초기화


        //2) X,Y,C 노드 정보 graph에 입력하기
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y,z));//단방향 그래프

        }

        //3) 다익스트라 알고리즘
        dij(c);

        //4) 정답 출력
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 노드인 경우
            if (d[i] != (int)1e9) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);

    }
    public static void dij(int start){
        q.offer(new Node(start,0));
        while(!q.isEmpty()){
            Node node = q.poll();

            if(d[node.idx] < node.time) continue;//이미 최단 거리로 누적되었다면 패스

            for(int i = 0;i< graph.get(node.idx).size(); i++){
                int cost = d[node.idx] + graph.get(node.idx).get(i).time;
                if (cost < d[graph.get(node.idx).get(i).idx]){
                    d[graph.get(node.idx).get(i).idx] = cost;
                    q.offer(new Node(graph.get(node.idx).get(i).idx, cost));
                }
            }

        }


    }
}
