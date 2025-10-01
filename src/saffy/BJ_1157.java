package saffy;
import java.util.Scanner;
//10분
public class BJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*문자열 입력*/
        String str = sc.next();
        /*문자열 대문자 변환*/
        str = str.toUpperCase();

        /*0-26까지 알파벳 체크 0:65-65 ->'A'*/
        char[] alpha  = new char[26];
        for(int i = 0; i<str.length(); i++) {
            int c = str.charAt(i)-0;
            alpha[c-65]+=1;
        }

        int max= -1;
        int idx = 0;
        int max_cnt = 0;
        for(int i = 0; i<26; i++) {
            if(max<alpha[i]) {
                max = alpha[i];
                idx = i;
                max_cnt = 0;
            }
            else if(max == alpha[i])
                max_cnt+=1;

        }
        /*정답 출력*/
        char result = ' ';
        if(max_cnt ==0) {
            result = (char)(idx+65) ;
            System.out.println(result);
        }
        else
            System.out.println("?");
    }
}
