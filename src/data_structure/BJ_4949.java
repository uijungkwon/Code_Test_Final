package data_structure;
import java.util.*;

public class BJ_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = sc.nextLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean result = true;

            if(str.equals("."))break; //종료문

            for(int i= 0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c =='(')
                    stack.push(c);
                else if(c == '[')
                    stack.push(c);
                //닫힌 괄호문일때 로직 잘 정해야함
                else if(c ==')'){
                    if(stack.isEmpty() || stack.peek() !='(') {
                        result  = false;
                        break;
                    }
                    else stack.pop();
                }
                else if(c ==']'){
                    if(stack.isEmpty() || stack.peek() !='[') {
                        result = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            if(!stack.isEmpty())
                result = false;

            if(result) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }


        /*정답 출력*/
        System.out.println(sb);
    }
}
