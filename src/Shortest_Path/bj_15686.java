package Shortest_Path;
import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y =y;
    }

}
public class bj_15686 {
    static int n,m;
    static List<Point> home= new ArrayList<>();
    static List<Point> chicken= new ArrayList<>();
    static Point[] output;
    static int result = (int)1e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) 도시 크기 (N) 최대 치킨집(M) 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        output = new Point[m];
        //2) graph 입력
        int[][]graph = new int[n+1][n+1];//1행부터 시작
        for(int i = 1 ; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; j++){
                int num = Integer.parseInt(st.nextToken());
                //1) 집일 경우
                if( num == 1)
                    home.add(new Point(i,j));
                //2) 치킨집일 경우
                else if(num == 2)
                    chicken.add(new Point(i,j));

                graph[i][j] = num;
            }
        }

        //3) 집을 탐색하면서 치킨 거리 탐색하기
        dfs(0,0,m);

        //4) 정답 출력
        System.out.println(result);

    }
    public static void dfs(int start, int depth, int m){
        //재귀 종료 조건
        if(depth == m){
            ///최소 거리 구하는 조건 적기(확인)
            int sum = 0;
            for(int i = 0; i< home.size(); i++){
                //변수 초기화
                int min = (int)1e9;//각 집이 치킨집까지의 거리를 구할 때 최소
                for(int j = 0; j<m; j++){
                    int tmp = Math.abs(home.get(i).x - output[j].x)+ Math.abs(home.get(i).y - output[j].y);
                    min  = Math.min(min, tmp);

                }
                sum+=min;
            }

            result = Math.min(result, sum);

            return;
        }

        for(int i = start; i<chicken.size(); i++){
            output[depth] = chicken.get(i);

            dfs(i+1, depth+1, m);//재귀 호출
        }

    }
}
