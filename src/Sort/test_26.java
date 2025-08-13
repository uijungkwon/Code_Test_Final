package Sort;
import java.io.*;
import java.util.*;

public class test_26 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new PriorityQueue<>();//기본 설정: 오름 차순

        for(int i= 0; i<n; i++)
            q.offer(sc.nextInt());

        int sum =0;
        while(q.size()>1){
            int a = q.poll();
            int b = q.poll();

            sum += (a+b);
            q.offer(a+b);
        }
        System.out.println(sum);


    }
}
