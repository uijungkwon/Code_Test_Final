package saffy;
import java.util.*;
//11분
public class BJ_2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*카드 개수 입력*/
        int N = sc.nextInt();

        /*마지막 남는 카드 탐색*/
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=N; i++) {
            q.offer(i);
        }

        while(q.size() !=1) {
            q.poll();
            q.offer(q.poll());
        }
        int result = q.poll();

        /*정답 출력*/
        System.out.println(result);
    }

}
