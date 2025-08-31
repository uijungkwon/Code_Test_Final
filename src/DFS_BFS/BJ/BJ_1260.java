package DFS_BFS.BJ;
import java.util.*;
import java.io.*;

public class BJ_1260 {
    //정점 개수 (N), 간선 개수(M) (양방향)
    static int n, m,v;
    static boolean[] visited;//왜? 조합이 아니라 탐색 여부때문에 설치 해둔 것
    static List<ArrayList<Integer>> list = new ArrayList<>();//이중 리스트 생성
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());//시작 노드번호

        visited = new boolean[n+1];
        //리스트 초기화
        for(int i = 0; i<= n; i++){
           list.add(new ArrayList<Integer>());
        }

        //간선 정보 입력//양방향 그래프
        for(int i =  0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        //DFS 결과 출력
        dfs(v);
        System.out.println();
        visited = new boolean[n+1];
        //BFS 결과 출력
        bfs(v);
    }
    public static void dfs( int start){
        visited[start] = true;
        System.out.print(start+" ");

        for(int i = 0; i< list.get(start).size(); i++){
            //정렬
            Collections.sort(list.get(start));
            int vertex = list.get(start).get(i);
            if(!visited[vertex])//다시 안바뀜//이게바로 재귀를 막아주는 제약
                dfs( vertex);
        }
    }
    public static void bfs(int start){
        Queue<Integer> q  = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            System.out.print(num+" ");//탐색 순서대로
            for(int i = 0; i< list.get(num).size(); i++){
                //정렬
                Collections.sort(list.get(num));

                int vertex = list.get(num).get(i);
                if(!visited[vertex]){
                    visited[vertex] = true;
                    q.offer(vertex);
                }
            }
        }
    }
}
