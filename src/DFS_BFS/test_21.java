package DFS_BFS;
import java.util.*;
import java.io.*;
public class test_21 {
    static int N,L,R;
    static int[][] map;
    static boolean[][] visited;
    static int[]dx = new int[]{0,0,-1,1};
    static int[]dy = new int[]{1,-1,0,0};
    static ArrayList<int[]> list;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) N,L,R 입력
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];


        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //2) map 내용 입력 받기
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //3) 인구 이동 시작하기

        int result = 0;//인구 이동하는 횟수

        while (true) {
            boolean isMove = false; //이동 여부(단 하나라도 연합국을 찾지 못한 경우 false)
            visited = new boolean[N+1][N+1];

            //하루에 여러개의 연합국이 나올 수 있으므로 이 반복문은 하루에 이동하는 것을 기록
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visited[i][j]) {
                        int sum = dfs(i, j); //연합국의 개수 찾기(덩어리 찾기)
                        if (list.size() > 1) {// 연합국이 존재하는 경우
                            change(sum); // 국경이 열린 노드끼리 인구 이동
                            isMove = true;//더 인구 이동 할 수 있는지 체크 하는 여부
                        }
                    }
                }//안쪽 for문
            }//바깥 for문


            if (!isMove) {//더이상 인구 이동을 할 수 없다면 break;
                break;
            }
            result++;
        }
        System.out.println(result);
    }
    public static int dfs(int x, int y){//아이스크림 찾기 처럼 "하나의 덩어리" 찾기!
        //각각의 queue와 list에는 하나의 연합국 정보만 있음 그래서 main의 반복문 사용
        Queue<int[]> union = new LinkedList<>();
        union.offer(new int[]{x,y});

        list = new ArrayList<>();
        list.add(new int[]{x,y});

        visited[x][y] = true;
        int sum = map[x][y];

        while(!union.isEmpty()){
            int[] tmp = union.poll();
            for(int i = 0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];

                //1) map 밖으로 벗어나는 경우
                if(nx<=0 || ny<=0 || nx>N|| ny>N)continue;

                //2) 방문한 적 없고, 연합국 조건에 만족하는 경우
                if (!visited[nx][ny] && L <= Math.abs(map[tmp[0]][tmp[1]] - map[nx][ny])
                        && Math.abs(map[tmp[0]][tmp[1]] - map[nx][ny]) <= R){
                    visited[nx][ny] = true;
                    union.offer(new int[]{nx,ny});//같은 연합국 좌표에 담는다.(탐색용)
                    list.add(new int[]{nx, ny});// 같은 연합국 좌표에 담는다.(저장용)
                    sum+=map[nx][ny];//모든 연합국의 합을 구함
                }

            }


        }

        return sum;//덩어리를 찾았다면 모든 연합국의 합을 반환
    }
    public static void change(int sum){//연합국 인구수 조정
        int people = (int)(sum/list.size());
        for(int[] tmp: list){
            map[tmp[0]][tmp[1]] =people;
        }


    }
}
