package Greedy;
import java.util.*;
import java.io.*;
public class BJ_13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] km = new int[N-1];
        int[] li = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){
            km[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            li[i] = Integer.parseInt(st.nextToken());
        }

        /*정답 출력*/
        long result =0;//출발할 때 기름 초기화
        long min = li[0];//리터가 가격이다.
        for(int i = 0; i<N-1; i++){
            if(min> li[i]) min = li[i];

            result+=(min*km[i]); //평행선으로 가니까 최솟값 끌고 가도 OK
        }
        /*정답 출력*/
        System.out.println(result);
    }
}
