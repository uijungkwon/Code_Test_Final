package saffy;
import java.util.*;
public class BJ_21921 {
//34분
//처음시도 : 2중 for문 으로 구간합 => 시간 초과
//최종 시도: 누적합으로 구간합 구함 => 성공

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        /*블로그 진행(N), 기간(X) 입력*/
        int N = sc.nextInt();
        int X = sc.nextInt();

        /*N일 동안 들어온 방문자 수 입력*/
        int[] blog = new int[N+1];
        for(int i = 1; i<=N; i++)
            blog[i] = blog[i-1]+sc.nextInt();//누적합으로 구하기

        /*X일 동안 들어온 최대 방문자 수 탐색*/
        int max = -1;//최대 방문자수
        int count = 0;//최대 방문자수를 가진 기간

        for(int i = X; i<=N; i++) {
            int sum = blog[i]-blog[i-X];
            if(max<sum) {
                max = sum;
                count = 1;
            }
            else if(max == sum)
                count+=1;
        }

        if(max == 0)
            System.out.println("SAD");
        else System.out.println(max+"\n"+count);


    }

}
