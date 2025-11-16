package data_structure;
import java.util.*;
public class BJ_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=N; i++)
            q.offer(i);

        sb.append('<');
        while(q.size()>1){//한 개 남을 때 까지
            for(int i = 0; i<K-1; i++){
                //일단 뺄 놈을 찾을때까지 뒤로 보내놓음(바퀴 굴러가듯 원형 구현)
                q.offer(q.poll());//순서대로
            }
            sb.append(q.poll()).append(", ");

        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}
