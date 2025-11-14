package data_structure;
import java.util.*;
import java.io.*;

public class BJ_9012 {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();

        /*테스트 시작*/
        for(int t = 0; t<tc; t++){
            Deque<Character> stack = new ArrayDeque<>();
            String s = sc.next();
            String result = "YES";

            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c=='(')stack.push(c);
                else if(c==')'){
                    if(!stack.isEmpty() && stack.peek() =='(')
                        stack.pop();
                    //탐색이 끝나지 않았는데 이미 비어있으면 균형깨짐
                    else {
                        result = "NO";
                        break;
                    }
                }
            }
            //밖으로 나왔는데도 stack에 무언가 남아있으면 탈락
            if(!stack.isEmpty())result = "NO";

            sb.append(result).append('\n');
        }
        /*정답 출력*/
        System.out.println(sb);
    }


}
