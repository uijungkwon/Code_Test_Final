package Dynamic;
import java.util.*;
import java.io.*;
public class BJ_10986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        /*탐색 시작*/
        long cnt = 0L;
        long[] C = new long[m];
        long[] s = new long[n+1];

        s[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i= 1; i<=n; i++){
            long num = Long.parseLong(st.nextToken());
            s[i] = (s[i-1]+num)%m;

            if(s[i] ==0) cnt++;//자기 자신을 포함하는 식
            //System.out.println(s[i]);
            C[(int)s[i]] = C[(int) s[i]]+1 ;//각 나머지 값 별로

        }
        //2.최대 쌍의 개수 구하기
        for(int i= 0; i<m; i++){
            cnt = cnt+(C[i]*(C[i]-1)/2);//항상2개씩 뽑음(구간이니까)
        }

        /*정답 출력*/
        System.out.println(cnt);
    }
}
