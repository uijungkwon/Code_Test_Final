package data_structure;
import java.util.*;
import java.io.*;
public class BJ_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        Set<Integer> A = new HashSet<>();
        for(int i = 0; i<N; i++){
            A.add(sc.nextInt());
        }
        int M = sc.nextInt();
        /*M개의 숫자를 입력받아 A 에 있는지 확인*/
        for(int i = 0; i<M; i++){
            int num = sc.nextInt();
            if(A.contains(num))
                sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
        /*정답 출력*/
        System.out.println(sb);
    }
}
