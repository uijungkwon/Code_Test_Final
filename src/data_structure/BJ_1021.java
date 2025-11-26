package data_structure;
import java.util.*;
public class BJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*큐의 크기 N, 뽑아내려는 원소 개수M*/
        int N = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        /*덱 초기화-> 위치가 곧 숫자다. A1 = 1*/
        for(int i = 1; i<=N; i++){
            dq.offer(i);
        }
        int M = sc.nextInt();
        int count = 0;

        /*M개의 뽑아내려는 수의 "위치" 입력=> 위치가 곧 숫자이다.*/
        //핵심: 덱의 앞쪽인지 뒤쪽인지 파악-> 앞쪽이면 큐, 뒤쪽이면 역방향 큐로 구현
        for(int i= 0; i<M; i++){
            int idx = sc.nextInt();//뽑아내려는 수의 위치
            int pos = 0;//현재 덱에서 idx의 위치(pos)를 찾는다

            /*매번 수열이 변화하므로 idx(처음 상태의 위치이기때문에 숫자와 동일)의 위치 먼저 찾아야함*/
            for(Integer in:dq){
                if(in == idx)break;
                pos++;//"전제에 원소는 "앞"에서만 뽑는다고 되어있음 => 앞에서부터 파악(순회가능)
            }


            if(pos == 0){//맨 앞에 있는 경우
                dq.pollFirst();
                continue;
            }
            else if(pos<=dq.size()/2){//앞쪽에 있는 경우=> 큐 처럼 구현
                for(int j = 0; j<pos; j++){
                    dq.offerLast(dq.pollFirst());//왼쪽으로 이동
                    count++;//2번 연산 누적
                }
                dq.pollFirst();//출력

            }
            else{//반시계 방향으로 이동 (무조건 뺄 놈이 앞으로 와야함
                for(int j = 0; j<dq.size()-pos; j++){
                    dq.offerFirst(dq.pollLast());//왼쪽으로 이동
                    count++;//2번 연산 누적
                }
                dq.pollFirst();//출력//같아지면 나와서 출력
            }
        }

        /*결과 출력*/
        System.out.println(count);
    }
}
