package data_structure;
import java.util.*;//10분
public class BJ_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            String order = sc.next();

            switch(order){
                case "push":{
                    int num = sc.nextInt();
                    q.offer(num);
                    break;
                }
                case "pop":{
                    if(!q.isEmpty())
                        sb.append(q.poll()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }
                case "size":{
                    sb.append(q.size()).append('\n');
                    break;
                }
                case "empty":{
                    if(q.isEmpty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case "front":{
                    if(!q.isEmpty())
                        sb.append(q.peekFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }
                case "back":{
                    if(!q.isEmpty())
                        sb.append(q.peekLast()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                }

            }

        }


        /*정답 출력*/
        System.out.println(sb);
    }
}
