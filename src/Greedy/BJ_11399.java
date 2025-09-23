package Greedy;
import java.util.*;
public class BJ_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] time = new int[N];
        for(int i = 0; i< N; i++){
            time[i] = sc.nextInt();
        }
        Arrays.sort(time);//오름차순 정렬

        int sum  = 0;
        int total = 0;
        for(int i = 0; i<N; i++){
            sum = sum+time[i];//누적합
            total = total+sum;
        }

        System.out.println(total);
    }
}
