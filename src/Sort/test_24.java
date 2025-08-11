package Sort;//안테나
import java.util.*;
import java.io.*;

public class test_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//집의 개수
        int[] house = new int[n];
        for(int i = 0; i<n; i++)
            house[i] = sc.nextInt();

        Arrays.sort(house);
        //집의 개수가 홀 수 일 때
        if( n %2 !=0)
            System.out.println(house[n/2]);
            //집의 개수가 짝수 일 경우
        else System.out.println(house[n/2-1]);


    }
}
