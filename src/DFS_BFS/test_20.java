package DFS_BFS;
import java.util.*;
import java.io.*;
/*
* 오류: 좌표 탐색을 할 때 q를 전역 변수로 사용
* ----> 탐색할 때 "q.poll()"를 하니까 계속해서 q는 없어지고 채워지지 않는 상황
* ----> q를 전역변수로 옮겨서 장애물을 세울 때마다 q에 값을 저장하고 뺄 수 있도록 수정
* ----> Queue 를 사용할 때는 poll()을 하면 값을 아예 빼버리니까 이 점 주의하기
* */

public class test_20 {
    static int n;
    static String[][] map;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0,};
    static int[] t = new int[2];//(x,y) 좌표 표시
    static int[] s = new int[2];//(x,y) 좌표 표시

    static ArrayList<int[]> student = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1) n 입력 및 변수 초기화
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        //2) S,T,O의 초기 위치를 입력 받는다
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n;j++){
                String s= st.nextToken();
                map[i][j] = s;
                if(s.equals("S")){//학생이라면 좌표에 저장
                    student.add(new int[]{i,j});//꺼낼 일 없고 확인용
                }
            }
        }
        //3) 탐색하기
        //3-1 ) 3개의 벽을 세울 수 있는 곳 탐색
        dfs(0);

        //4) 결과 출력(모든 경우를 찾아봐도 없는 경우)
        System.out.println("NO");
    }
    public static void dfs(int depth){
        if (depth == 3) {
            //학생이 가려지는지 탐색
            bfs();
            return;//재귀 종료
        }
        //X 표시가 된 좌표의 모든 경우에 벽을 탐색//임의로 세웠다가 삭제할것이라서 copy본 필요없음
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j].equals("X")){
                    map[i][j] = "O";
                    dfs(depth+1);
                    map[i][j] = "X";//원상 복귀
                }
            }
        }
    }
    public static void bfs(){//3개의 벽이 세워진 상태
        //1) 선생님 위치 기준으로 감시할 수 있는 영역 true로 체크
        String[][] copy = new String[n][n];
        boolean[][] search = new boolean[n][n];//매번 새롭게 초기화
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++)
             copy[i] = map[i].clone();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j].equals("T")) {
                    search[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }



        while(!q.isEmpty()){
            int[] node = q.poll();//(2,1)
            int x = node[0];
            int y = node[1];
            for(int i = 0; i<4; i++){
                //1) 상하좌우 중, 하나의 방향을 정함
                int nx = x+dx[i]; //첫 초기화
                int ny = y+dy[i];

                //2) 벽을 만나거나 바깥으로 나가기 직전까지 한방향탐색
                while(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!copy[nx][ny].equals("O") ){

                        search[nx][ny] = true;
                        nx = nx + dx[i];
                        ny = ny + dy[i];
                    }
                    else break;//장애물 만나면 바로 빠져나오기

                }
            }
        }

        //2) 학생영역이 true 인지 확인 하기
        if(check(search)){

            System.out.println("YES");
            System.exit(0);
        }
        //맞을 경우엔 계속해서 탐색
    }
    public static boolean check(boolean[][] search){
        for(int[] stu : student){
            if(search[stu[0]][stu[1]])//하나라도 true 면 감시당한거임
                return false;
        }

        return true;
    }
}
