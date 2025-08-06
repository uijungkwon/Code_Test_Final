package DFS_BFS;
import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int index;
    int distance;
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    @Override
    public int compareTo(Node o) {
        return this.distance-o.distance;
    }
}

public class test_15{
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[]d;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //도시개수(N), 도로의개수(M), 거리 (K), 출발 도시(x) 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        d = new int[n+1];

        //최단 거리 테이블 초기화
        Arrays.fill(d, (int)1e9);

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,1));
        }
        dij(x);
        //최단거리 k에 맞는지 확인
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i<=n; i++)
            if(d[i] == k)
                result.add(i);
        if(result.size() == 0) //아예 찾지 못했다면
            System.out.println(-1);
        else{
            Collections.sort(result);
            for(int i : result)
                System.out.println(i);
        }
    }
    public static void dij(int start){
        Queue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node node =pq.poll();
            int now = node.index;
            int dist = node.distance;

            if(d[now] < dist )continue;//이미 탐색

            for(int i = 0; i< graph.get(now).size(); i++){
                int cost = dist + graph.get(now).get(i).distance;
                if(d[graph.get(now).get(i).index] > cost) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }

            }


        }




    }

}