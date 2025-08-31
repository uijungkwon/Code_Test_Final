package DFS_BFS.BJ;

import java.util.*;

public class BJ_1707 {
    static int v,e;//정점과 간선개수
    static int[] color;
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //테스트 케이스 시작
        for(int tc = 0; tc<t; tc++){
            v = sc.nextInt();
            e = sc.nextInt();
            //graph 초기화
            for(int i = 0; i<=v; i++){
                graph.add(new ArrayList<>());
            }
            //간선 정보 입력
            for(int i= 0; i<e; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            //인접한 v에 다른 색 칠하기 (뚜렷한 기준이 없으므로 1번부터 탐색)-> 인접한 색 탐색-> BFS
            //예외사항: 지금 이순간 덩어리들을 탐색하는 dfs 안함 -> bfs할 경우 1번 부터 탐색-> 1번이 있는 덩어리만 탐색-> 나머지 덩어리 못봄
            //해결책: 모든 정점(v)를 탐색하면서 해당 덩어리 안에서 이분 그래프 맞는지 탐색
            color = new int[v+1];
            String answer = "YES";
            for(int i = 1; i<=v; i++){//모든 정점을 탐색
                //탐색 되지 않은 부분만(!visited)처럼
                if(color[i] == 0){//이 조건을 넣지않으면 순서대로 모두 그냥 다 탐색함
                    if(!bfs(i)){//한 부분이라도 틀리면 바로 빠져나와서 출력
                        answer = "NO";
                        break;
                    }
                }


            }

            System.out.println(answer);


        }


    }
    public static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1;//확인표시 색칠 (초기화 버전)

        while(!q.isEmpty()){

            int vertex = q.poll();

            for(int i = 0; i< graph.get(vertex).size(); i++){
                int idx = graph.get(vertex).get(i);//인접한 정점의 값

                //color가 정의 된 상태라면
                if(color[vertex] == color[idx]){
                    return false;
                }



                //color가 아직 정의 되지 않았다면
                if(color[idx] == 0){
                    color[idx] = color[vertex]*-1;//반댓값으로 색칠
                    q.offer(idx);

                }
            }


        }
        return true;//모두 통과
    }
}
