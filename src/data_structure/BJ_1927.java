package data_structure;
import java.util.*;
public class BJ_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();//기본_오름차순
        for(int i = 0; i<N; i++){
            int x = sc.nextInt();
            if(x == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
            else{
                pq.offer(x);
            }
        }
        /*정답 출력*/
        System.out.println(sb);
    }
}
