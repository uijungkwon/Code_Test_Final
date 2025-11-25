package data_structure;
import java.util.*;
public class BJ_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Character> stack = new ArrayDeque<>();
        int sum = 0;
        String str = sc.next();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c =='('){
                stack.push(c);
            }
            else if(c==')'){//무조건 짝이 맞는 괄호 생성
                stack.pop();
                if(str.charAt(i-1) =='('){//레이저일 경우(바로 이전과 짝을 이룰 경우
                    sum = sum+stack.size();//레이저랑 막대기를 따로 구해서 자르는게 아님!
                }
                else{//레이저가 아닌 일반 괄호가 닫혀서 막대기 1개가 끝난 상황 -> 당연히 닫힌 괄호당 원소 1개니까
                    sum++;
                }
            }
        }
        /*정답 출력*/
        System.out.println(sum);
    }
}
