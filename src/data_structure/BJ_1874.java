package data_structure;
import java.util.*;
public class BJ_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();

        /*N개의 수열 생성*/
        int[] nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        /*수열 탐색 및 스택 연산*/
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        boolean chk = true;//스택 연산이 가능한지 여부

        for(int i = 0; i<N; i++){
            /*스택의 top과 일치하면 바로 뽑음*/
            if(!stack.isEmpty() && stack.peek().equals(nums[i])){
                stack.pop();
                sb.append('-').append('\n');//연산을 문자열로 기록하는 것이기 때문에 무조건 추가
                continue;
            }
            /*스택에 있는 숫자가 수열보다 크면 절대 성공 불가 -> break*/
            else if(!stack.isEmpty() && stack.peek() > nums[i]){
                chk = false;
                break;
            }

            /*뽑으려는 수까지 push*/
            while(idx<=nums[i]){
                stack.push(idx);
                sb.append('+').append('\n');
                idx++;//idx값은 계속 저장되어있음
            }
            /*뽑기*/
            stack.pop();
            sb.append('-').append('\n');

        }
        /*정답 출력*/
        if(chk) System.out.println(sb);
        else System.out.println("NO");
    }
}
