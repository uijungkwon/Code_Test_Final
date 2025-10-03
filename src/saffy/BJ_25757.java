package saffy;
import java.util.*;
//14분
public class BJ_25757 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*신청 횟수N, 게임 종류 입력*/
        int N = sc.nextInt();
        char game = sc.next().charAt(0);
        int count = 0;

        if(game =='Y')
            count = 1;
        else if(game=='F')
            count = 2;
        else if(game =='O')
            count = 3;

        /*신청자 명단 입력*/
        Set<String> nameList = new HashSet<>();
        for(int i = 0; i<N; i++) {
            nameList.add(sc.next());
        }

        /*게임 최대 진행 횟수*/
        int result = nameList.size()/count;

        /*정답 출력*/
        System.out.println(result);

    }

}
