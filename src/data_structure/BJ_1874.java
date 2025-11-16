package data_structure;
import java.util.*;
public class BJ_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num  = new int[N];
        for(int i = 0; i<N; i++){
            num[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean result = true;
        int idx =1;
        for(int i = 0; i<N;i++){//while문 같은 역할
            /*stack의 초기값 셋팅*/
            for(; idx<=num[i]; idx++){//시작 구간을 정하지 않고, 끝 구간(수열의 숫자)
                stack.push(idx);
                sb.append('+').append('\n');
            }
            /*peek와 값이 똑같으면 pop 진행*/
            if(stack.peek() == num[i]){
                stack.pop();
                sb.append('-').append('\n');
            }
            else result = false;//한번만 맞지 않아도 규칙성이 깨짐
        }
        if(!result) System.out.println("NO");
        else System.out.println(sb);


    }
}
