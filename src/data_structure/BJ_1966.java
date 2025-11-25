package data_structure;
import java.util.*;
import java.io.*;
class Order implements Comparable<Order>{//우선순위 큐를 사용하기 위해서는 정렬 사용!
    int num;//중요도
    int idx;//인덱스
    public Order(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
    @Override
    public int compareTo(Order o){//중요도 내림차순 정렬 //얘는 일단 중요도만 비교함
        return o.num - this.num;
    }
}
public class BJ_1966 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        /*테스트 케이스 시작*/
        for(int t = 0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//기본타입_내림차순
            Queue<Order> q = new LinkedList<>();

            /*문서의 중요도 입력*/
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){//순서는 0번부터 시작
                int num = Integer.parseInt(st.nextToken());
                Order o  = new Order(num, i);
                pq.offer(num);//숫자만 내림차순으로 정렬 -> q가 이걸보고 정렬
                q.offer(o);

            }
            /*pq에서 M번째 원소가 몇번째로 출력할 지 계산*/
            int count =1;
            while(!pq.isEmpty()){
                int n = pq.poll();//기준 숫자 꺼내기

                while(q.peek().num !=n ){
                    q.offer(q.poll());
                }
                if(q.poll().idx == M) break;//인덱스까지 일치하면 아웃

                count++;

            }

            /*정답 저장*/
            sb.append(count).append('\n');
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
