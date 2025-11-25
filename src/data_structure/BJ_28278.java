package data_structure;
import java.util.*;
public class BJ_28278 { //8분
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        /*명령의 수 N 입력*/
        int N = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            int order = sc.nextInt();
            switch(order){
                case 1:{
                    int num = sc.nextInt();
                    stack.push(num);
                    break;
                }
                case 2:{
                    if(!stack.isEmpty()){
                        sb.append(stack.pop()).append('\n');
                    }
                    else sb.append(-1).append('\n');
                    break;
                }
                case 3:{
                    sb.append(stack.size()).append('\n');
                    break;
                }
                case 4:{
                    if(stack.isEmpty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case 5:{
                    if(!stack.isEmpty()){
                        sb.append(stack.peek()).append('\n');
                    }
                    else sb.append(-1).append('\n');
                    break;
                }
            }
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
