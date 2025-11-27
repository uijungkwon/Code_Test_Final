package data_structure;
import java.util.*;
public class BJ_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*숫자의 개수N, 수열 입력*/
        int N = sc.nextInt();
        Set<Integer> set =new HashSet<>();
        for(int i = 0; i<N; i++){
            set.add(sc.nextInt());
        }

        /*M과 M개의 수 입력*/
        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        for(int i = 0; i<M; i++){
            int num = sc.nextInt();
            if(set.contains(num))
                sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
