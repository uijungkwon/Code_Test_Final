package data_structure;
import java.util.*; //27분
public class BJ_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*괄호 입력*/
        String str = sc.next();
        /*괄호 짝 맞추기를 위한 스택 생성*/
        Deque<Character> stack = new ArrayDeque<>();

        /*괄호 순차 탐색(짝이 맞는 괄호)*/
        int result = 0;
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                /*레이저인지 확인*/
                if(str.charAt(i+1) == ')')//i와 i+1이 바로 붙었는지 확인
                    result+=stack.size();//지금까지 넣은 막대 개수
                else stack.offerLast(c);
            }

            else if(c ==')') {
                if(str.charAt(i-1) == '(')//레이저가 아니라면
                    continue;
                else{
                    stack.pollLast();//어차피 한번에 1개가 짝지어서 빠지기 때문에 괄호가 닫히면 무리에서 벗어남!
                    result+=1;
                }

            }
        }
        /*정답 출력*/
       System.out.println(result);
    }
}
