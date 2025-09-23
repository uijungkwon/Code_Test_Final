package Greedy;
import java.util.*;

public class BJ_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        /*입력받은 문자열 str을 -기준으로 잘라 배열에 저장*/
        String[] plus = str.split("-");
        StringTokenizer st;

        int result = 0;
        for(int i = 0; i<plus.length; i++){
            st = new StringTokenizer(plus[i],"+");
            int num = 0;//한덩어리 당 합을 num으로 표현

            while(st.hasMoreTokens()){
                num = num+Integer.parseInt(st.nextToken());
            }

            if(i == 0)
                result = num;
            else result = result-num;//뺄셈 연산 진행

        }

        /*결과 출력*/
        System.out.println(result);

    }
}
