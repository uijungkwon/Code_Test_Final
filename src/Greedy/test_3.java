package Greedy;//문자열 뒤집기//최소 횟수 출력
import java.util.*;
public class test_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1) 문자열 입력
        String s = sc.next();

        //연속된 하나이상의 숫자를 한번에 뒤집는다. -> point 한회에 한 덩어리만 뒤집을 수 있다.
        int count0 = 0;
        int count1 = 0;
        //전략: 0덩어리 1덩어리 개수를 세서 최소 가 답(처음은 초기화)

        if(s.charAt(0) == '0')
            count0 = 1;

        else count1 = 1;

        for(int i = 0; i<s.length()-1; i++){

            if(s.charAt(i) == s.charAt(i+1))continue;//같은 덩어리에 속함

            else{//덩어리가 바뀔 경우
                if(s.charAt(i+1) == '1') {//타입 맞추기^
                    count1++;
                }
                else count0++;

            }
        }

        //정답 출력
        System.out.println("count0: "+count0+"count1: "+count1);
        int result = Math.min(count0, count1);
        System.out.println(result);
    }
}

