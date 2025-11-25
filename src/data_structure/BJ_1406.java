package data_structure;
import java.util.*;
public class BJ_1406 {//list의 가변적 특징을 사용하는 문제
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        String str = sc.next();//기준 문자열 입력
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        /*문자열을 문자 단위로 list에 저장*/
        for(int i = 0; i<str.length(); i++)
            left.add(str.charAt(i));

        int N = sc.nextInt();//명령어 개수
        /*N회 동안 명령어 수행*/
        for(int tc = 0; tc<N; tc++){
            char c = sc.next().charAt(0);
            if(c == 'L' && !left.isEmpty()){
                right.offerFirst(left.pollLast());//뒤에꺼 빼서 옮기기
            }
            else if(c == 'D' && !right.isEmpty()){
                left.offerLast(right.pollFirst());
            }
            else if(c == 'B' && !left.isEmpty()){
                left.pollLast();
            }
            else if(c == 'P'){
                char ch = sc.next().charAt(0);//추가할 문자 입력 받음
                left.offerLast(ch);
            }

        }
        /*정답 출력*/
        while(!left.isEmpty())
            sb.append(left.pollFirst());
        while(!right.isEmpty())
            sb.append(right.pollFirst());
        System.out.println(sb);
    }
}
//탐색 구현하기 // =>  탐색 알고리즘