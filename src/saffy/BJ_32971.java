package saffy;
import java.util.Scanner;
//12분

public class BJ_32971 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1) H,W,N,M 입력
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        //2) 탐색
        /*빈공간 한 가운데에 첫번째 놈을 놓고, 기준으로 n,m칸씩 띄워서 앉게하기*/
        int result =0;

        for(int i = 0; i<W; i = i+M+1) {
            for(int j = 0; j<H; j = j+N+1) {
                result++;

            }

        }

        //3) 정답 출력
        System.out.println(result);

    }
}

