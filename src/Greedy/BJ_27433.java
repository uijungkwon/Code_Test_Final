package Greedy;
import java.util.*;
public class BJ_27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long result = fac(N);

        System.out.println(result);

    }

    public static long fac(int num){
        if(num <= 1)
            return 1; //더이상 재귀호출 하지 않고 끝맺음
        else return num*fac(num-1);
    }
}
