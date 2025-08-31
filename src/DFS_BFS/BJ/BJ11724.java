package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class BJ11724 {
    static int n,m;//정점과 간선개수
    static boolean[] visited;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];//1번부터!
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i= 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        //탐색 시작
        int result = 0;
        for(int i = 1; i<=n; i++){//시작 번호 상관 없음
            if(!visited[i]){
                dfs(i);
                visited[i] = true;
                result++;//덩어리 자체 개수
            }
        }

        System.out.println(result);
    }
    public static void dfs(int start){

        for(int i = 0; i< list.get(start).size(); i++){
            int vertex = list.get(start).get(i);
            if(!visited[vertex]){
                visited[vertex] = true;
                dfs(vertex);
            }
        }

    }
}
