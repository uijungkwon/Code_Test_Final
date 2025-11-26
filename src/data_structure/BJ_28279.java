package data_structure;
import java.util.*; //12분
public class BJ_28279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        int N = sc.nextInt();
        /*테스트 진행*/
        for(int i = 0; i<N; i++){
            int num = sc.nextInt();
            /*8가지 명령*/
            switch(num){
                case 1:{
                    int x = sc.nextInt();
                    dq.offerFirst(x);
                    break;
                }
                case 2:{
                    int x = sc.nextInt();
                    dq.offerLast(x);
                    break;
                }
                case 3:{
                    if(!dq.isEmpty())
                        sb.append(dq.pollFirst()).append("\n");
                    else sb.append(-1).append("\n");

                    break;
                }
                case 4:{
                    if(!dq.isEmpty())
                        sb.append(dq.pollLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                }
                case 5:{
                    sb.append(dq.size()).append("\n");
                    break;
                }
                case 6:{
                    if(!dq.isEmpty())
                        sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                }
                case 7:{
                    if(!dq.isEmpty())
                        sb.append(dq.peekFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                }
                case 8:{
                    if(!dq.isEmpty())
                        sb.append(dq.peekLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                }


            }
        }
        /*정답 출력*/
        System.out.println(sb);
    }
}
