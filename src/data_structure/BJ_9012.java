package data_structure;
import java.util.*;
//15분
public class BJ_9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*명령어 개수 N 입력*/
        int N = sc.nextInt();

        /*N회 동안 테스트 */
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack ;


        for(int i =0; i<N; i++){
            //새로운 괄호문 입력시 초기화
            String str = sc.next();
            boolean chk = true;
            stack = new ArrayDeque<>();

            for(int j = 0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == '(')
                    stack.push(c);
                else{
                    if(stack.isEmpty()){//틀린경우1
                        chk = false;
                        break;
                    }
                    else stack.pop();
                }

            }
            /*탐색 끝난 후 stack 점검*/
            if(!stack.isEmpty())//틀린 경우 2
                chk = false;

            /*정답 출력*/
            String result = "NO";
            if(chk) result = "YES";
            sb.append(result).append('\n');
        }


        System.out.println(sb);
    }
}
