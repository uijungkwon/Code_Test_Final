package BackTrack;

import java.util.Scanner;

public class BJ_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//0<=N <=20
        int result = fibo(N);

        System.out.println(result);
    }
    public static int fibo(int num){
        if(num == 0)
            return 0;
        else if(num == 1)
            return 1;
        else return fibo(num-1)+fibo(num-2);
    }
}
