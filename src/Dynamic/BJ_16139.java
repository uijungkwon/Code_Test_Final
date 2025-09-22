package Dynamic;
import java.io.*;
import java.util.*;
public class BJ_16139 {
    /*누적합 문제가 숫자에서 벗어나 문자에도 적용가능함을 알린 문제 -> 2차원 알파벳 배열 사용*/
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        /*문자열, 질문 횟수 입력(모두 소문자)*/
        String S = br.readLine();
        int size = S.length();
        int[][] alpha = new int[26][size+1];//'행'은 알파벳 개수

        for(int i= 1 ; i<=size; i++){
            int ch = S.charAt(i-1)-97;

            for(int j = 0;j<26; j++){
                if(j == ch)
                    alpha[j][i] = alpha[j][i-1]+1;//1씩 누적더함
                else{//다르다면 이전의 값 끌고옴
                    alpha[j][i] = alpha[j][i-1];
                }
            }
        }


        /*질문횟수(q)만큼 루프를 돌면서 게임 진행*/
        int q = Integer.parseInt(br.readLine());
        for(int k = 0; k<q; k++){
            st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);//한 글자니까
            int a = Integer.parseInt(st.nextToken())+1;
            int b = Integer.parseInt(st.nextToken())+1;

            int result = alpha[ch-97][b]-alpha[ch-97][a-1]; //값을끌고와서 최신 시작점과 무관하게 마지막 점 찾기



            sb.append(result).append("\n");
        }
        /*정답 출력*/
        /*출력 횟수가 많을 경우 sb를 사용한다. */
        System.out.println(sb);
    }
}
