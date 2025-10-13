package saffy;
import java.util.*;
import java.io.*;
//50분
public class BJ_19637 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        /*칭호 개수(N), 캐릭 터 수 (M)입력*/
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*칭호의 이름, 전투력 상한값 오름차순 입력*/
        String[] name = new String[N];
        int[] val = new int[N];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int v =  Integer.parseInt(st.nextToken());

            name[i] = n;
            val[i] = v;
        }

        /*M개의 캐릭터 전투력 입력*/
        for(int i =0; i<M; i++) {
            int power = Integer.parseInt(br.readLine());
            int idx = binary(val,power);

            sb.append(name[idx]).append('\n');
        }

        /*전투력에 맞게 칭호 출력*/
        System.out.println(sb);

    }
    public static int binary(int[] val, int power) {
        //나무를 잘라낸 최소 or 최대 길이를 찾으면 "값을"기준으로 이분 탐색
        //지정된 범위 안에 속하는지 T,F만 파악한다면 "인덱스"를 기준으로 이분 탐색
        int l = 0; int r = val.length-1;
        int ans =val.length-1;

        while(l<=r) {
            int mid = (l+r)/2;
            if(val[mid] >= power) {
                ans = mid;//정답이 되는 인덱스를 미리저장//
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }


        return ans;
    }

}
