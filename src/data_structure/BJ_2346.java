package data_structure;
import java.util.*;
//한 시간 이상
public class BJ_2346 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       StringBuilder sb = new StringBuilder();

       int N = sc.nextInt();
       Deque<Integer[]> dq = new ArrayDeque<>();
       for(int i = 1; i<=N; i++){
           int num = sc.nextInt();
           dq.offer(new Integer[]{i,num});
       }

       /*항상 첫번째 풍선 부터 터뜨리기*/
       sb.append(1).append(" ");
       int distance = dq.poll()[1];

       /*모든 풍선 터뜨리기*/
        while(!dq.isEmpty()){
            if(distance>0){//숫자가 양수라면
                for(int i= 0; i<distance-1; i++){
                    dq.offerLast(dq.pollFirst()); //조정해서 내가 뽑고 싶은 숫자를 가리키도록 셋팅
                }
                sb.append(dq.peekFirst()[0]).append(" ");
                distance = dq.pollFirst()[1];
            }
            else{//숫자가 음수라면
                distance = Math.abs(distance);
                for(int i= 0; i<distance-1; i++){
                    dq.offerFirst(dq.pollLast()); //조정해서 내가 뽑고 싶은 숫자를 가리키도록 셋팅
                }
                sb.append(dq.peekLast()[0]).append(" ");
                distance = dq.pollLast()[1]; //맨 뒤를 가리키게됨
            }
        }


       /*정답 출력*/
        System.out.println(sb);
    }
}
