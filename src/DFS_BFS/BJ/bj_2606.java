package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class bj_2606 {
    static int n;//컴퓨터 개수
    static int m;//간선 개수
    static boolean[] visited;
    static int result= 0;//연결된 컴퓨터 개수
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //컴퓨터개수와 간선 개수 입력
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        //graph 초기화
        for(int i = 0; i<=n ; i++){
            graph.add(new ArrayList<>());
        }

        //graph 정보 입력 받기
        StringTokenizer st;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //양방향
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //컴퓨터 탐색
        dfs(1);//1번부터 탐색

        System.out.println(result-1);
    }
    public static void dfs(int start){
        visited[start] = true;
        result++;
        for(int i= 0; i< graph.get(start).size(); i++){
            int vertex = graph.get(start).get(i);
            if(!visited[vertex])
                dfs(vertex);
        }

    }
}
