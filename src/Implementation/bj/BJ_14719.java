package Implementation.bj;
import java.util.*;
import java.io.*;
public class BJ_14719 {
    static int n,m;
    static int[] block;
    static List<Integer> rain  = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        block = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            block[i] = num;
        }

        //빗물이 고일 수 있는 조건
        //"현재" 블록 보다 왼쪽 블록이 높아야한다.
        //"현재" 블록 보다 오른쪽 블록이 높아야한다.
        //"양끝에" 블록이 없으면 고일 수 없다.

            int sum = 0;

            for(int i = 1; i<m-1; i++){
                int left = 0;
                int right = 0;

                for(int j = 0; j<i; j++){
                    left = Math.max(block[j],left);
                }
                for(int j = i+1; j<m; j++){
                    right = Math.max(block[j],right);
                }

                if(block[i] <left && block[i] < right){//Point: 최댓값 중의 최솟값을 기준으로 빗물을 받을 수 있음
                    sum = sum +(Math.min(left, right) - block[i]);
                }

        }
        System.out.println(sum);
    }
}
