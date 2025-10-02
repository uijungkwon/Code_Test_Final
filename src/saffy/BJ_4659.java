package saffy;
import java.util.*;

public class BJ_4659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Set<Character> vowel = new HashSet<>();

        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        /*테스트 시작*/
        while(true) {
            String str = sc.next();
            /*end입력하면 게임 종료*/
            if(str.equals("end"))break;

            /*변수 설정*/
            boolean result = false;

            if (str.length() == 1) {
                // 한 글자는 모음일 때만 acceptable
                result = vowel.contains(str.charAt(0));
            }

            else {
                //무조건 전체 글자는 탐색해야한다.
                boolean check =vowel.contains(str.charAt(0));
                int cnt_v = vowel.contains(str.charAt(0)) ? 1 : 0; // 현재 모음 연속 길이
                int cnt_c = vowel.contains(str.charAt(0)) ? 0 : 1; // 현재 자음 연속 길이
                int i = 1;

                for(i = 1; i<str.length(); i++) {
                    char now = str.charAt(i);
                    char prev = str.charAt(i-1);
                    boolean nowV  = vowel.contains(now);
                    boolean prevV = vowel.contains(prev);

                    /*모음이 있는지 확인*/
                    if (nowV) check = true;

                    // 같은 종류(모음/자음)면 연속 길이 증가, 다르면 현재 종류를 1로 리셋
                    if (nowV == prevV) {
                        if (nowV) cnt_v++;
                        else      cnt_c++;
                    } else {
                        if (nowV) { cnt_v = 1; cnt_c = 0; } //내가 초기화하면 다른 놈은 없애버리기
                        else      { cnt_c = 1; cnt_v = 0; }
                    }

                    // 3연속 금지
                    if (cnt_v == 3 || cnt_c == 3) break;

                    // 같은 문자 두 번 연속(ee, oo는 예외)
                    if (now == prev && now != 'e' && now != 'o') break;

                }//for문

                if (i == str.length() && check) result = true;
            }




            /*정답 저장*/
            if(result)
                sb.append("<").append(str).append(">").append(" is acceptable.\n");
            else
                sb.append("<").append(str).append(">").append(" is not acceptable.\n");

        }//while문


        /*정답 출력*/
        System.out.println(sb);

    }

}
