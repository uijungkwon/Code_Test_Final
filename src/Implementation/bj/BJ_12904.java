package Implementation.bj;

import java.util.*;
/*
* 첫번째 시도 : 브루트 포스 알고리즘 사용(매 깊이 마다 두가지 연산의 모든 경우의 수 구함) : 시간초과
* 문제점: dp를 사용하기엔 문자열 데이터라서 까다로움
* 해결책: 그리디 알고리즘을 사용해 최적화 탐색 진행 반대로 생각해서 T-> S가 되는 경우를 생각
* 즉 반대로 T 문자열에서 끝에 A가 있으면 그냥 떼고, B가 있으면 B를 떼고 문자열을 뒤집어준다.-> 문자열 사라짐
* 위 방식으로 하면 재귀호출 하지 않아도 되고 단순 반복문 안에 if-else를 넣어서 만듦
* */

public class BJ_12904 {
    public static void main(String[] args)  {
        /*문자열 게임
         * S가 주어지면 T로 바꾼다
         * 규칙: 1)문자열의 뒤에 A를 추가한다. 2)문자열을 뒤집고 뒤에 B를 추가한다. -> 두개의 연산만 할 수 있다
         * 변경 가능 : 1, 변경 불가: 0 출력
         * */

        Scanner sc = new Scanner(System.in);
        String S = sc.next();//길이 S<T
        String T = sc.next();

        /* 첫번째 시도 : 브루트 포스 알고리즘
        dfs(S,T);
        System.out.println(0);//아예 못찾았다면*/

        /*두번째 시도*/
        int result = 0;

        while(S.length()< T.length()){
            int k = T.length()-1;//문자열의 가장 끝자리

            if(T.charAt(k)== 'A'){
                T = T.substring(0,k);//문항 번호
            }
            else{
                T = T.substring(0,k);
                String tmp="";
                for(int i= T.length()-1; i>=0; i--){
                    tmp = tmp+T.charAt(i);
                }
                T = tmp;
            }

            if(S.length()== T.length()){
                if(S.equals(T)) {
                    result = 1;
                    break;
                }
            }

        }
        System.out.println(result);

    }
    public static void dfs( String S, String T){//시작은 S길이 <T 길이
        if(S.length() == T.length()){
            if(S.equals(T)) {
                System.out.println(1);
                System.exit(0);//단 하나라도 같은게 있으면 1 반환후 끝내기
            }

            return;//깊이를 정해놓고 여기까지 오면 반환시키기
        }

        //둘다 모두 하는 경우의 수 진행

        /*1번 연산*/
        dfs( S+'A', T);

        /*2번 연산*/
        String temp = "";
        for(int i=S.length()-1; i>=0; i--){
            temp = temp+S.charAt(i);
        }
        temp = temp+'B';
        dfs( temp, T);


    }
}
