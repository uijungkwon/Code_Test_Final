package Dynamic;
import java.util.*;
import java.io.*;
class Top implements Comparable<Top>{
    int a;
    int b;

    public Top(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Top o) {
        return this.a-o.a;//a값을 기준으로 오름차순 정렬
    }
}
public class BJ_2565 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*전기줄 개수*/
        int n = Integer.parseInt(br.readLine());
        List<Top> elec = new ArrayList<>();

        /*A,B 전봇대와 연결된 전깃줄 정보 입력*/
        for(int i = 1; i<=n; i++){
            /*위치의 번호는 500이하의 자연수 , 같은 위치에 두개 이상 연결 불가*/
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            elec.add(new Top(a,b));
        }
        /*A기준 정렬*/
        Collections.sort(elec);

        /*B에 해당하는 가장 긴 오름차순 LCS 찾기*/
        int[] dp = new int[n];
        /*dp 초기화*/
        for(int i = 0; i<n; i++){
            dp[i] = 1;
        }
        /*LCS 찾기*/
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(elec.get(i).b > elec.get(j).b){
                    dp[i] = Math.max(dp[i], dp[j]+1);//dp에는 계속해서 최댓값 누적
                }
            }
        }
        /*설치 가능한 전기줄 개수*/
        int max = -1;
        for(int i = 0; i<n; i++){
            max = Math.max(max,dp[i]);
        }

        /*결과 출력*/
        int result = n-max;
        System.out.println(result);

    }
}
