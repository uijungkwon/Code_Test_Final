package data_structure;
import java.util.*;
import java.io.*; //37분

public class BJ_4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("."))break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean balance = true;//괄호 짝 여부 확인

            for(int i = 0; i<str.length(); i++){
                char c = str.charAt(i);
                /*열린 괄호 일 때*/
                if(c =='(' || c=='['){
                    stack.push(c);
                }
                /*닫힌 괄호 일 때*/
                else if(c ==')' || c == ']'){
                    if(c==')' &&  !stack.isEmpty() && stack.peek() == '(' ) {
                        stack.pop();
                    }
                    else if(c==']' && !stack.isEmpty() && stack.peek()=='[')stack.pop(); //이미 해당 스택에서 짝 꺼냄
                    else {//이 외에 경우엔 모두 틀림
                        balance = false;
                        break;
                    }
                }
            }

            /*원소가 남아 있으면 실패*/
            if(!stack.isEmpty())balance = false;
            /*정답 저장*/
            if(balance) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
