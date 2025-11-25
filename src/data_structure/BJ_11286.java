package data_structure;
import java.util.*;
public class BJ_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue pq=  new PriorityQueue<>(new MyComp());
        /*연산 시작*/
        int N = sc.nextInt();
        for(int i = 0; i<N; i++){
            int x = sc.nextInt();
            if(x == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');//출력한 값을 배열에서 제거
            }
            else{
                pq.offer(x);
            }
        }

        /*정답 출력*/
        System.out.println(sb);
    }
    /*우선순위 큐를 위한 정렬 클래스 생성*/
    public static class MyComp implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            int a = Math.abs(o1); //객체의 주소값 참조하기 때문에 "Integer => int"형으로 바꿔서 계싼할 것
            int b = Math.abs(o2);

            if(a == b)
                return Integer.compare(o1,o2);//작은 수 부터//Integer 기본객체가 갖고있는 compare 함수!
            else
                return Integer.compare(a,b);
        }
    }
}
