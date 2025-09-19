package Dynamic;

import java.util.Scanner;
/*
* 나의 논리, 오름차순 내림차순 수열 개수 구하기 ok
* 그것을 합치고 겹치는 원소값을 빼보자!
* */

public class BJ_11054 {
    static int[]A;
    static int[]dp_up;
    static int[]dp_down;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = new int[n+1];
        for(int i = 1; i<=n; i++){
            A[i] = sc.nextInt();
        }

        /*가장 긴 오름차순 수열 탐색*/
        dp_up= new int[n+1];//오름 차순
        dp_down= new int[n+1];//내림 차순
        for(int i= 1; i<=n; i++){
            dp_up[i] = 1;//초기화
            dp_down[i] = 1;//초기화
        }
        int max = -1;
        /*오름차순 */
        for(int i = 2; i<=n; i++){
            for(int j = 1; j<i; j++){
                if(A[i] > A[j]){
                    dp_up[i] = Math.max(dp_up[i], dp_up[j]+1);
                }

            }
        }
        /*내림차순*/
        for(int i = n-1; i>=1; i--){
            for(int j = i+1; j<=n; j++){
                if(A[i] > A[j]){//내림 차순 만족
                    dp_down[i] = Math.max(dp_down[i], dp_down[j]+1);//계속 갱시할 필요 없이 "최소값중 최댓값" 찾기 권법!
                }

            }
        }
        /*바이토닉 합*/
        for(int i= 1; i<=n; i++){
            max = Math.max(dp_up[i]+dp_down[i], max);
        }

        System.out.println(max-1);
    }

}
