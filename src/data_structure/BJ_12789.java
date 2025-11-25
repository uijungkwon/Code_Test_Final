package data_structure;
import java.util.*;
//30분

public class BJ_12789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*학생 수N과 번호표 입력*/
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i<N; i++){
            numbers[i] = sc.nextInt()-1;
        }

        /*탐색*/
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for(int i = 0; i<N; i++){
            /*번호표 탐색과 동시에 안에서 스택 구현*/
            while(!stack.isEmpty() && stack.peek() == idx){
                stack.pop();
                idx++;
            }

            if(idx == numbers[i])
                idx++;
            else stack.push(numbers[i]);
        }

        String result = "Nice";
        /*마지막으로 미쳐 빠져나오지 못한 stack의 수 확인*/
        if(!stack.isEmpty()){
            for(int i = 0; i<stack.size(); i++){
                if(idx == stack.pop())
                    idx++;//아까 멈춰 놓았던 idx 가동
                else {
                    result = "Sad"; //한 순간이라도 일치 하지 않으면 틀림
                    break;
                }
            }
        }

        /*결과 출력*/
        System.out.println(result);
    }
}
