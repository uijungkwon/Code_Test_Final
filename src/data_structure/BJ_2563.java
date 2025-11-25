package data_structure;
import java.util.*;
//16분
public class BJ_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*정사각형의 개수 N 입력*/
        int N = sc.nextInt();
        boolean[][] square = new boolean[100][100];

        /*검은 영역의 개수 */
        int count = 0;

        /*N개의 정사각형 위치 입력*/
        for(int i = 0; i<N; i++){
            int s = sc.nextInt();//x좌표가 떨어진 지점
            int e = sc.nextInt();//y좌표가 떨어진 지점

            for(int j = e; j<e+10; j++){//y위치 만큼
                for(int k = s; k<s+10;k++){
                    if(!square[j][k]){
                        square[j][k] = true;
                        count++;
                    }
                }
            }

        }

        /*정답 출력*/
        System.out.println(count);

    }

}
