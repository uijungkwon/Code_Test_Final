package saffy;
import java.util.Scanner;
public class BJ_2292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1; //단계
        int range = 2;//최소 방의개수(2부터 시작)

        if(N == 1)
            System.out.println(1);

        else {
            while(range<=N) {//최소방의 개수니까 큰 수의 제한만 걸고 밑은 보지 않아도됨
                range = range+ (6*cnt);//ex)최대 7이됨
                cnt++;
            }
            System.out.println(cnt);
        }



    }

}
