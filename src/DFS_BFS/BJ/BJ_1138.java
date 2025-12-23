package DFS_BFS.BJ;

import java.util.*;
public class BJ_1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[]left = new int[N];
        for(int i = 0; i<N; i++)
            left[i] = sc.nextInt();
        /*탐색 시작*/
        List<Integer> list = new ArrayList<>();

        //줄은 오름 차순으로 서게됨(가장 큰 키 부터 삽입하기 - 자기 앞에 큰놈이 없으니까)
        for(int i = N; i>=1; i--){//키는 1번 부터 N번
            list.add(left[i-1], i);//(인덱스 값)
        }
        /*정답 출력*/
        for(int i= 0; i<N; i++)
            System.out.print(list.get(i)+" ");
    }
}
