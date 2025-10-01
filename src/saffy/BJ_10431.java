package saffy;
import java.util.*;
import java.io.*;
//16분 -> 문제의 의미 파악 , 뭘 구해야하는지
public class BJ_10431 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        int[] height = new int[20];

        for(int i= 0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            sb.append(t).append(" ");

            /*20명의 학생 키 입력*/
            for(int j = 0; j<20; j++) {
                height[j] = Integer.parseInt(st.nextToken());
            }
            /*학생들을 키 순서대로 정렬*/
            int count = sort(height);
            sb.append(count).append("\n");
        }
        /*
         * 랜덤으로 한명뽑아 맨 앞에 세운다.
         * 뒤로 줄세우기
         * 1.자기 앞에보다 키가 큰 학생이 없으면 그냥 서있는다
         * 2. 자기 앞에 자기보다 키큰 학생이 한 명 이상 있다면, 그중 가장 앞에 있는 학생A 앞에선다
         *   이때, A부터 그 뒤 모든 학생들은 +1씩 뒤로 간다.
         *   1,2번을 반복해라
         *
         *   목표: 오름차순 정렬 할때 몇번 뒤로 물러날지 count 세기
         * */
        System.out.println(sb);

    }
    public static int sort(int[] arr) {
        int cnt = 0;
        for(int i = 1; i<20; i++) {
            for(int j = 0; j<i; j++) {
                /*내 앞에 나보다 키큰 학생이 있을 때*/
                if(arr[i] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    cnt++;//물러나는 횟수 (진짜로 배열 원소를 미룰 필요는 없고, swap만 해도 바꿀 수 있음(
                }

            }

        }



        return cnt;
    }


}
