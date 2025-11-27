package data_structure;
import java.util.*;
//5분
public class BJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*1~N이 담긴 q 초기화*/
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<=N; i++){
            q.offer(i);
        }
        /*큐에 카드 한 장 남을 때까지 반복*/
        while(q.size()!=1){
            //맨 위 카드를 버린다.
            q.poll();
            //맨 위 카드를 바닥으로 옮긴다.
            q.offer(q.poll());
        }


        /*정답 출력*/
        int result= q.poll();
        System.out.println(result);
    }
}
