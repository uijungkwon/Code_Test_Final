package data_structure;
import java.util.*;
//스택 사용하여 리팩토링 (원리 파악)
public class BJ_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Deque<Character> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        String tmp="";
        /*괄호 안 일반문자열인지, 괄호 밖 일반 문자열인지 구별 */
        boolean chk = false;//디폴트 값 : 괄호 밖 문자열 (스위치 역할)

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '<'){
                while(!stack.isEmpty()) //앞에 등장한 문자열들 처분
                    sb.append(stack.pop());
                chk =true;//괄호 안 문자열 의미 표시
                sb.append('<');
            }
            else if(c =='>'){
                chk = false;//이제 괄호 밖 표시
                sb.append('>');
            }
            else{
                if(chk){//괄호 '안' 문자열 일 때
                    sb.append(c);//그대로 출력
                }
                else{//괄호 '밖' 문자열 일 때
                    if(c ==' '){//공백이면 한 덩어리 끝난거니까 먼저 출력
                        while(!stack.isEmpty())
                            sb.append(stack.pop());
                        sb.append(" ");
                    }
                    else
                        stack.push(c);
                }
            }

        }
        /*마지막으로 tmp가 비어있는지 확인*/
        while(!stack.isEmpty())//for문 끝난후 스택에 "한덩어리" 남아있는지 비어있는지 확인
            sb.append(stack.pop());
        /*정답 출력*/
        System.out.println(sb);
    }
    public static String back(String str){
        //"공백" 단위로 거꾸로 출력
        String tmp = "";
        String[]s = str.split(" ");
        for(int i= 0; i<s.length; i++){
            for(int j = s[i].length()-1; j>=0; j--){
                tmp+=String.valueOf(s[i].charAt(j));//덩어리 마다 거꾸로 붙이기
            }
            if(i != s.length-1)
                tmp+=" ";
        }
        return tmp;
    }
}
