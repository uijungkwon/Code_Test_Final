package Dynamic;
import java.io.*;
import java.util.*;
public class BJ_2559 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = (int)-1e9;

        int[] num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            if(i==1)
                num[i] = Integer.parseInt(st.nextToken());
            else{
                num[i] = num[i-1]+ Integer.parseInt(st.nextToken());
            }

        }
        /*탐색 시작 */
        int idx = 0;
        for(int i = K; i<=N; i++){
            int temp = num[i]-num[idx];
            max = Math.max(max,temp);
            idx++;
        }
        System.out.println(max);
    }
}

