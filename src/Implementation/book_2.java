package Implementation;//115p
import java.util.*;

public class book_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1) 좌표 위치 입력
        String pos = sc.nextLine();

        int col = pos.charAt(0)-'a'+1;
        int row = pos.charAt(1)-'0'; //1번부터 시작

        //2) 갈 수 있는 방향을 좌표로 정의(상하좌우 이동 개념)기존 좌표+움직일 수 있는 가동거리
        int result =0;
        int[] dx = new int[]{2,-2,2,-2,1,-1,1, -1};//col
        int[] dy = new int[]{1,1,-1,-1,-2,-2,2,2};//row

        for(int i = 0; i<8; i++){
            int nx = col+dx[i];
            int ny = row+dy[i];

            if( nx>=1 && nx<=8 && ny>=1 && ny<=8)
                result++;
        }

        System.out.println(result);
    }

}
