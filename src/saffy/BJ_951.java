package saffy;
import java.util.*;
//60분 //"그리디 알고리즘" (최댓값 찾기)
//그리디 알고리즘에서는 최대 아님 최소 찾기를 원하기 때문에 "우선순위를 정해야한다"
//가로등 알고리즘만 비슷 -> 어떤 햄버거를 선택할지 고민 ->"왼쪽 "먼저 선택하는게 최선이다 ->탐색 범위 설정 후 알고리즘 작성
public class BJ_951 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*N과 K입력*/
        int N = sc.nextInt();
        int K = sc.nextInt();

        /*테이블 입력*/
        String s = sc.next();
        boolean[] check = new boolean[N];//햄버거 먹을 수 있는지 확인 테이블
        //왼쪽부터 햄버거 확인하는 것이라면 "오름차순"이므로, 찾는 햄버거 부터 true로 하여 먹을 수 있다/

        int count = 0;
        for(int i = 0; i<s.length();i++) {
            char c = s.charAt(i);
            /*햄버거 범위가 테이블을 벗어날 수 있으므로 범위 설정*/
            int start = 0;
            int end = 0;

            if(c=='P') {//사람 기준으로 탐색
                /*햄버거 탐색 범위 설정 */
                if((i-K) <0)start = 0;
                else start = i-K;

                if((i+K)>=N)end = N-1;
                else end = i+K;

                /*가장 왼쪽 햄버거 부터 "우선순위"로 탐색하며 먹는다.*/
                for(int j = start ; j<=end; j++) {//범위가 벗어날 경우
                    if(!check[j]&& s.charAt(j)=='H') {//오름차순 순서대로
                        check[j] = true;
                        count+=1;
                        break;//먹을 수 있는거 찾으면 끝

                    }
                }

            }
        }
        /*정답 출력*/
        System.out.println(count);
    }

}

