package saffy;
import java.util.*;
public class BJ_2607 {
    //60분
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] alpha = new int[26];//모두 0으로 초기화
        int[] copy = new int[26];//모두 0으로 초기화
        int count = 0;

        for(int i = 0; i<N; i++) {
            String s = sc.next();
            int plus = 0;
            int minus = 0;
            /*기준 문자열 */
            if(i==0) {
                for(int j = 0; j<s.length(); j++) {
                    alpha[s.charAt(j)-65]+=1;
                }
            }
            /*비교 문자열 */
            else {
                copy = Arrays.copyOf(alpha,alpha.length);//계속 계산하기 위해서 카피본 생성
                for(int j = 0; j<s.length(); j++) {
                    copy[s.charAt(j)-65]-=1;//기준 문자열에서 뺄셈
                }
                /*plus, minus 개수세기*/
                for(int j = 0; j<26; j++) {
                    if(copy[j]>=0)
                        plus+=copy[j];
                    else
                        minus+=copy[j];
                }
                if(Math.abs(plus)<=1 && Math.abs(minus)<=1)//비슷한 구성 관계
                    count++;
            }

        }
        /*정답 출력*/
        System.out.println(count);

    }

}