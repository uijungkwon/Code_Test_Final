package DFS_BFS.BJ;

import java.util.Scanner;

public class BJ_1748 {
    public static void main(String[] args) {
        //처음부터 끝까지 자릿수 다 탐색함
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //두자리일 땐 *2, 세자리 일 땐 *3
        int multi = 1;
        int count = 0;
        int idx = 10;

        for(int i = 1; i<=N; i++){
            if(i%idx ==0){//자릿수 바뀌는 시점//10단위로
                //i%10 하면 20,30,50...모두 걸리게됨 10,100 이렇게 자릿수 변화 시점을 알고 싶음 ->
                multi+=1;
                idx = idx*10;//10단위로 늘리기
            }
            count = count + multi; //자릿수가 늘어나는 메커니즘은 파악 =>"전체" 탐색에 적용할 것
        }

        /*정답 출력*/
        System.out.println(count);
    }
}
