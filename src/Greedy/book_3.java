package Greedy;//99p_1이 될 때까지
import java.util.*;

public class book_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1) n과 k를 입력
        int n = sc.nextInt();
        int k = sc.nextInt();

        //2) n이 1이 될 때까지 연산 진행
        int cnt = 0;//연산 횟수
        while(n!=1){
            if(n%k == 0) //우선 순위
                n = n/k;
            else
                n = n-1;

            cnt++;
        }
        System.out.println(cnt);

    }
}
