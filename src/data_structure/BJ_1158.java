package data_structure;
import java.util.*;
//한방향 회전 -> 큐
public class BJ_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*N,K 입력*/
        int N = sc.nextInt();
        int K = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        /*큐 생성*/
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i<=N; i++)
            q.offer(i);

        /*k번째 요소 빼기*/
        while(q.size() !=1){
            for(int i = 1; i<K; i++)
                q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        /*정답 출력*/
        System.out.println(sb);
    }
}
