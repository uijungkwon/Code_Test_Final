package Dynamic;
import java.util.*;
import java.io.*;
public class BJ_10986 {
    /*수열 포함한 문제는 점화식 찾는게 포인트!*/
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        /*탐색 시작*/
        int result = 0;
        int[] S = new int[N+1];
        int[] C =new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            S[i] = (S[i-1]+Integer.parseInt(st.nextToken()))%3;


            if(S[i] == 0)result++;//자기 자신을 포함하는 구간 존재 -> 카운터 세기
            C[S[i]]++;
        }

        /*나머지가 0인 모든 구간의 경우의 수  탐색 하기 */
        for(int i = 0; i<M; i++){
            int temp = C[i]*(C[i]-1)/2;
            result+=temp;
        }

        /*결과 출력*/
        System.out.println(result);
    }
}
