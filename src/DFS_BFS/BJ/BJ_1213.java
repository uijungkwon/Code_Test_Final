package DFS_BFS.BJ;

import java.util.Scanner;

public class BJ_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] alpha = new int[26];
        for(int i = 0; i<str.length(); i++){
            alpha[str.charAt(i)-'A']++;//빈도수 저장//'A':65
        }

        int odd = 0;
        char mid=' ';//홀수인 알파벳 종류가 1개일 경우 중간에 붙일 문자

        /*빈도수가 홀수인 알파벳 종류 찾기*/
        for(int i = 0; i<26; i++){
            if(alpha[i] %2 ==1){
                odd++;
                mid = (char)(i+'A');//아스키 코드 사용
            }
        }
        /*펠린드롬 불가능 한 경우*/
        if(odd>1)
            System.out.println("I'm Sorry Hansoo");

        /*펠린 드롬 가능한 경우*/
        else{
            StringBuilder left = new StringBuilder();
            /*펠린드롬 왼쪽 부분 붙이기, 최대 "/2" 만큼 다 붙이기*/
            for(int i = 0; i<26; i++){//전체 알파벳 탐색
                for(int j = 0; j<alpha[i]/2; j++){//해당 알파벳의 반절만 붙이기
                    left.append((char)(i+'A'));//알파벳 붙이기
                }
            }

            /*펠린드롬 가운데 붙이기(있으면)*/
            StringBuilder result = new StringBuilder();
            result.append(left);
            if(odd == 1)
                result.append(mid);

            /*펠린드롬 오른쪽 붙이기(왼쪽을 뒤집어서)*/
            result.append(left.reverse());

            /*정답 출력*/
            System.out.println(result);

        }

    }

}
