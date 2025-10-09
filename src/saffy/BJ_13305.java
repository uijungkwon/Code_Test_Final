package saffy;
import java.util.*;
//14분 //변수의 "타입"을 고려해서 코드 짜기 int -> Long
public class BJ_13305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*도로 및 도시 입력*/
        int N = sc.nextInt();
        long[] road = new long[N-1];
        long[] city = new long[N];

        for(int i = 0; i<N-1; i++) {
            road[i] = sc.nextLong();
        }
        for(int i = 0; i<N; i++) {
            city[i] = sc.nextLong();
        }

        /*리터당 주유 가격 탐색*/
        long min = (int)1e9;
        long sum = 0;
        for(int i = 0; i<N-1; i++) {
            min = Math.min(min, city[i]);
            sum = sum+(min*road[i]);
        }

        /*정답 출력*/
        System.out.println(sum);

    }

}
