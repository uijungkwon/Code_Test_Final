package data_structure;
import java.util.*;

public class BJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        /*큐 초기화*/
        for(int i = 1; i<=N; i++){
            q.offer(i);
        }
        /*마지막 1개 남을 때까지 게임 진행*/
        while(q.size() !=1){
            q.poll();//맨 위 버리기
            q.offer(q.poll());// 그 다음 숫자를 뒤로 새로 넣기
        }
        /*정답 출력*/
        System.out.println(q.poll());
    }
}
