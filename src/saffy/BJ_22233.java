package saffy;
import java.util.*;
//15분
public class BJ_22233 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();

        /*메모장 입력*/
        Set<String> memo = new HashSet<>();//기준이 되는 "중복 없는 덩어리"에 확인하기 위해 Set 사용
        for(int i = 0; i<N; i++) {
            memo.add(sc.next());
        }

        /*글 입력*/
        for(int i = 0; i<M; i++) {
            String[] writting = sc.next().split(",");
            for(int j = 0; j<writting.length; j++) {//키워드 확인
                if(memo.contains(writting[j]))
                    memo.remove(writting[j]);
            }
            sb.append(memo.size()).append('\n');

        }

        /*정답 출력*/
        System.out.println(sb);
    }

}
