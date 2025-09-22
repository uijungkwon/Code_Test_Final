package Dynamic;
import java.util.*;
import java.io.*;
public class BJ_11659 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*수의 개수(N), 합을 구해야하는 횟수(M)*/
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*N개의 수 입력-> 누적합 구함*/
        int[] number = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<= N; i++){
            if(i == 1)
                number[i] = Integer.parseInt(st.nextToken());
            else{
                number[i] = number[i-1]+Integer.parseInt(st.nextToken());
            }
        }
        /*M회 동안 (a,b)구간의 합을 구해라 */
        for(int i= 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = number[b]-number[a-1];//어디까지 누적 저장되고 내가 빼서 쓸 수 있는지
            /*결과 출력*/
            System.out.println(result);
        }

    }
}
