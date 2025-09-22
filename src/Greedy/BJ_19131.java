package Greedy;
import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int start;
    int fin;
    public Node(int start, int fin){
        this.start = start;
        this.fin = fin;
    }

    @Override
    public int compareTo(Node o) {
        if(this.fin == o.fin){
            return this.start - o.start;//오름 차순
        }
        return this.fin - o.fin;//끝나는 시간 순서대로 정렬
    }
}
public class BJ_19131 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());//시간 : 0시~24시
        List<Node> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b));
        }
        /*회의 시간 정렬*/
        Collections.sort(list);

        /*겹치지 않는 구간 선택*/
        int result = 1;//첫번째 회의 선택
        int e = list.get(0).fin;//앞선 회의 끝난시각
        for(int i = 1; i<N; i++){
            if(e<=list.get(i).start){//앞 회의 끝난시간<=다음회의시작시간 -> 겹치지 않음
                result++;
                e = list.get(i).fin;
            }
        }

        /*정답 출력*/
        System.out.println(result);
    }
}
