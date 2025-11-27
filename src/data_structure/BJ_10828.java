package data_structure;
import java.util.*; //5분
public class BJ_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            String order = sc.next();
            switch(order){
                case "push":{
                    int num = sc.nextInt();
                    stack.push(num);
                    break;
                }
                case "pop":{
                    if(!stack.isEmpty())
                        sb.append(stack.pop()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }
                case "size":{
                    sb.append(stack.size()).append('\n');
                    break;
                }
                case "empty":{
                    if(stack.isEmpty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case "top":{
                    if(!stack.isEmpty())
                        sb.append(stack.peek()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }
            }
        }
        /*정답 출력*/
        System.out.println(sb);
    }
}
