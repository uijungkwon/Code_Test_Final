package Graph;
import java.util.*;
import java.io.*;

public class book_4 {
    static int[] indegree ;
    static int[] time;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1) 강의 수 입력
        int n = Integer.parseInt(br.readLine());//강의 번호 자동으로 부여
        indegree = new int[n+1];
        time = new int[n+1];
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            time[i] = x;

            while(true){
                x = Integer.parseInt(st.nextToken());
                if(x == -1)break;
                else{
                    indegree[i]++;
                    graph.get(x).add(i);
                }
            }
        }
        //탐색 및 결과 출력
        int[] result=  new int[n+1];
        for(int i = 1; i<=n; i++){
            result[i] = time[i];
        }
        //진입차수 0부터 Q에 넣고 모든 노드의 진입차수를 0으로 만들기
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i<graph.get(node).size(); i++){
                int in = graph.get(node).get(i);
                result[in] = Math.max(result[in],result[in]+time[node] );//동시에 수강 가능하므로 최댓값으로 누적해야한다.

                indegree[in]--;//진입차수 끊어버리기

                if(indegree[in] == 0) //모두 다 끊어진 건 큐에 집어넣기//나가는 놈 만 있도록 //그래야 덧셈을 진행할 수 있음
                    q.offer(in);
            }


        }
        for(int i = 1; i<=n; i++)
            System.out.println(result[i]);
    }
}
