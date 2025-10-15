package saffy;
import java.util.*;
import java.io.*;
//1시간 30분
//내가 간과한 점 : 미래의 주가를 알 수 있음 ->언제 제일 비쌀지 아니까 조금 올라도 팔지 않고 최대한 많이 올랐을때 팔기
//위와 같이 구성하려면 미래부터 과거로 돌아와야함 그래야 미래 최대로 주가가 올랐을 시점을 저장해두고 그보다 낮은값일 때 다 사버리는 거지
public class BJ_11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        /*테스트 시작*/
        for(int tc = 0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            /*주가 입력*/
            long[] arr = new long[N];
            for(int i = 0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            /*이익 탐색*/
            long max = 0L;
            long sum = 0L;
            for(int i = N-1; i>=0; i--) {
                if(arr[i]>max) max = arr[i];//max값만 누적함
                else {//미래의 max로 과거의 값을 파니까 모두 팔아버림
                    sum = sum+(max-arr[i]);
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
