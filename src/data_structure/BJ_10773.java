package data_structure;
import java.util.*;

public class BJ_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        int K = sc.nextInt();
        for(int i = 0; i<K; i++){
            int num = sc.nextInt();
            if(num ==0)
                stack.pop();
            else stack.push(num);
        }
        int sum = 0;
        while(!stack.isEmpty()){
            int n = stack.pop();
            sum+=n;
        }
        /*정답 출력*/
        System.out.println(sum);
    }
}
