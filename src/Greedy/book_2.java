package Greedy; //96p_숫자 카드 게임
import java.util.*;
public class book_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1)행과 열을 차례로 입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        //2) 카드에 적힌 숫자들 입력
        int[][] card = new int[n][m];
        for(int i= 0; i<n; i++){
            for(int j = 0; j<m; j++){
                card[i][j] = sc.nextInt();
            }
        }
        //3) 각 행에 적힌 숫자 카드들을 정렬
        /*먼저 행을 선택한 후 해당 행에서 숫자를 뽑는다. 이때 해당 행에서 가장 작은 숫자를 뽑는다.
        가능한 최대한 높은 숫자를 뽑을 수 있도록 전략을 세워야한다.
        */
        for(int i = 0 ; i<n; i++){
            Arrays.sort(card[i]);
        }
        //4) 각 행에서의 최솟값들 중 최댓값 찾기
        int result = -1;
        for(int i = 0; i<n; i++){
            result = Math.max(result, card[i][0]);
        }
        System.out.println(result);
    }
}
