package data_structure;
import java.util.*;
public class BJ_11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //객체에 정렬 기준을 직접 정할 수 있지만, 생성자 함수에 정의할 수 있음
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());//생성자: 정렬 기준
        StringBuilder sb = new StringBuilder();

        for(int i= 0; i<N;  i++){
            int num = sc.nextInt();
            if(num == 0){
                if(!pq.isEmpty())
                    sb.append(pq.poll()).append('\n');
                else sb.append(0).append('\n');
            }
            else pq.offer(num);
        }
        System.out.println(sb);
    }
}
