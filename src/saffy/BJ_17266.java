package saffy;
import java.util.*;
//40분
public class BJ_17266 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*가로등 개수 및 위치 입력*/
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x  = new int[m];
        for(int i = 0 ; i<m; i++) {
            x[i] = sc.nextInt();
        }

        int max = (int)-1e9;
        /*첫 번째 가로등 까지*/
        max = Math.max(max, x[0]-0);
        /*중간 가로등*/

        for(int i= 0; i<(m-1); i++) {//가로등의 개수가 1개일때 작동하지 않음
            int gap = x[i+1]-x[i];
            max = Math.max(max, (gap+1)/2);
        }
        /*맨 끝에 있는 가로등*/
        max = Math.max(max, n- x[m-1]);

        /*정답 출력*/
        System.out.println(max);
    }

}