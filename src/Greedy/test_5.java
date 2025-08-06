package Greedy;
import java.util.*;

public class test_5 {
    static int[] output = new int[2];
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //볼링공 개수(N) 무게 입력(M)
        int n = sc.nextInt();
        int m = sc.nextInt();//최대 무게

        int[] ball = new int[n];
        for(int i = 0; i<n; i++)
            ball[i] = sc.nextInt();

        //볼링공 고르는 경우의 수 구하기
        combi(ball, 0,0,n,2);
        //무게가 같은 경우는 제외하기
        System.out.println(count);
    }
    public static void combi(int[] ball, int start, int depth, int n, int r){
        if(depth == r){
            if(output[0] != output[1])count++;
            return;
        }

        for(int i= start; i<n; i++){
            output[depth] = ball[i];
            combi(ball,i+1,depth+1,n,r);
        }
    }
}
