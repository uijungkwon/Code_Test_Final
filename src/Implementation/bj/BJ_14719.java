package Implementation.bj;
import java.util.*;
import java.io.*;
/*
* 첫번째 시도 실패 이유: 한 줄씩 보면서 매번 최대 높낮이를 찾으며 갱신하려고 했음 -> 오르막, 내리막 에따라서 무한대로 갱신해야한다는 문제점
* 해결책 : 내자신을 기준으로 양쪽 높이가 나보다 높다면 빗물이 고일 수 있음, 높은 벽 뒤에 가려진 애들은 어떤 길이라도 상관없음
* 따라서 for문을 돌면서 해당 자신 기준으로 왼쪽 최대, 오른쪽 최대길이를 각각 구한다.
* 낮은 높낮이에 맞춰서 물이 고이니까 그 둘중에 최소값 찾음 (최대중에 최소찾기)
* 자기자신과의 차이만큼 물이 채워짐 -> 모든 높낮이 마다 탐색
* -> 문제의 본질부터 깨닫고 한글로 적은 다음 -> 코드로 옮기기
* */

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
