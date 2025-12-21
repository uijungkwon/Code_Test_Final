package DFS_BFS.BJ;

import java.util.Scanner;

public class BJ_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*숫자 N 입력*/
        int N = sc.nextInt();
        int sum = 0;
        /*N이 두 자릿수 이하일 경우 */
        if(N<=99)
            System.out.println(N);
        else if(N == 100)
            System.out.println(99);
        else{//세 자릿수 이상일 경우
            sum = 99;//초기화
            for(int i = 101; i<=N; i++){
                if(check(i))
                    sum++;
            }
            System.out.println(sum);
        }
    }
    public static boolean check(int num){//전체 탐색
        /*등차수열 체크*/
        int n1 = (num/10)/10;
        int n2 = (num/10)%10;
        int n3 = num%10;

        if(n1-n2 == n2-n3)
            return true;
        return false;
    }

}
