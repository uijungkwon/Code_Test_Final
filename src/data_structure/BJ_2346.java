package data_structure;
import java.util.*;
//한 시간 이상
public class BJ_2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        /*풍선개수 N과 풍선에 담긴 숫자 입력*/
        int N = sc.nextInt();
        Deque<Integer[]> dq = new ArrayDeque<>();

        for(int i =1; i<=N; i++){
            int num = sc.nextInt();
            dq.offer(new Integer[]{i,num});
        }
        while(!dq.isEmpty()){
            Integer[] val= dq.pollFirst();
            sb.append(val[0]).append(" ");

            int idx = val[1];
            if(idx>0){
                int i = 0;
                for(int j = 0; j<idx-1; j++) {
                    dq.offerLast(dq.pollFirst());
                }
            }
            else{//꺼낸 숫자가 음수라면
                int i = 0;
                idx = Math.abs(idx);
                for(int j = 0; j<idx-1; j++) {
                    dq.offerFirst(dq.pollLast());
                }
                //한칸 이라면
            }

        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
