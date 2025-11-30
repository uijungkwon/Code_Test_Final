package data_structure;
import java.util.*; //12분
public class BJ_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//비교횟수

        PriorityQueue<Integer> pq=  new PriorityQueue<>();//기본 - 오름 차순 정렬
        /*카드 묶음 입력 */
        for(int i= 0; i<N; i++){
            pq.offer(sc.nextInt());
        }
        /*비교 연산*/
        int count = 0;
        while(pq.size() !=1){//최종적으로 1개의 카드묶음이 남을 때까지
            int sum = pq.poll()+pq.poll();//1회 연산
            count+=sum;//연산 횟수 누적
            pq.offer(sum);// 카드 묶음을 pq에 집어넣어 또 연산
        }
        /*정답 출력*/
        System.out.println(count);
    }
}
