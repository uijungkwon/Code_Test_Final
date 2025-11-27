package data_structure;
import java.util.*;
public class BJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*큐의 크기N과 뽑으려는 수 M 입력*/
        int N = sc.nextInt();
        int M = sc.nextInt();

        /*원형 큐 생성*/
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1;i<=N; i++)
            dq.offer(i);

        /*변수 설정*/
        int count =0;//2번,3번 연산의 횟수


        /*M개의 뽑으려는 수 입력 후 연산 진행*/
        for(int i = 0; i<M; i++){
            int num = sc.nextInt();
            int idx = 0;//매번 초기화 (0~dq.size()-1)
            /*큐에서 뽑으려는 수인 num의 위치를 탐색*/
            for(Integer in:dq){
                if(in == num)break;
                idx++;
            }

            /*찾은 위치로 연산 진행*/
            if(idx ==0){
                dq.pollFirst();
                continue;
            }
            else if(idx <= dq.size()/2){//num이 앞쪽에 있는 경우
                for(int j = 0;j<idx;j++) {
                    dq.offerLast(dq.pollFirst());//회전
                    count++;
                }
                dq.pollFirst();
            }
            else {//num이 뒤쪽에 있는경우(크기를 뒤에서 빼야함)
                for(int j = 0;j<dq.size()-idx;j++) {
                    dq.offerFirst(dq.pollLast());//회전
                    count++;
                }
                dq.pollFirst();
            }
        }
        /*정답 출력*/
        System.out.println(count);
    }
}
