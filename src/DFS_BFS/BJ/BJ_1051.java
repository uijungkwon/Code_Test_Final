package DFS_BFS.BJ;
import java.util.*;
import java.io.*;

public class BJ_1051 {
    static int min;
    static int[][] map;
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        min = Math.min(N,M);
        int result = 1;//자기 자신 포함
        boolean chk = false;
        /*정사각형이 될 수 있는 큰 경우부터 탐색*/
        while (min >=2) {//한 변의 길이가 1인건 취급하지 않음
            for(int i =0 ; i<=N-min; i++){//자르는 꼭짓점 범위
                for(int j = 0; j<=M-min; j++){
                    if(check(i,j)){//가장 큰 너비부터 시작하므로 찾으면 끝
                        result = min*min;
                        chk = true;
                        break;
                    }
                }
                if(chk)break;
            }
            if(chk)break;

            min--;//하나씩 줄여나감
        }

        /*가장 먼저 찾은 정사각형 넓이를 결과로 출력*/
        System.out.println(result);

    }
    /*정사각형 체크 함수 */
    public static boolean check(int x, int y){//맨 왼쪽 꼭짓점
        //min: 한 변의 길이
        int len = min-1;
        if(map[x][y] == map[x][y+len] && map[x][y] == map[x+len][y] && map[x+len][y]==map[x+len][y+len]){
            return true;
        }

        return false;//못찾으면 false
    }
}
