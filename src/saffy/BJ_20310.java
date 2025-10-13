package saffy;
import java.util.Scanner;
public class BJ_20310 {
    //48분
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        /*문자열 s 입력*/
        String s = sc.next();
        char[] ch = new char[s.length()];
        int cnt0 = 0;//전체 0의 개수
        int cnt1 = 1;//전체 1의 개수

        //0과 1의 개수 세기
        for(int i =1; i<=s.length(); i++) {
            char c = s.charAt(i-1);
            ch[i-1] = c;

            if(c=='0') cnt0++;
            else if(c=='1') cnt1++;
        }

        /*0과1의 개수를 절반 지운다*/
        cnt0 = cnt0/2;
        cnt1 = cnt1/2;

        /*0지우기*/
        for(int i = s.length()-1; i>=0; i--) {
            if(cnt0> 0 && s.charAt(i)=='0' ) {
                ch[i] = '8';//지웠다는 표시
                cnt0--;
            }
        }
        /*1지우기*/
        for(int i = 0; i<s.length(); i++) {
            if(cnt1> 0 && s.charAt(i)=='1' ) {
                ch[i] = '8';//지웠다는 표시
                cnt1--;
            }
        }
        /*정답 출력*/
        for(int i = 0; i<s.length(); i++) {
            if(ch[i] !='8')
                sb.append(ch[i]);
        }


        System.out.println(sb);
    }
}