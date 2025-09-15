package Implementation.bj;
import java.util.*;
import java.io.*;
class Idx {
    int x;
    int y;
    int move;//물고기
    public Idx(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move; //상어로 부터 떨어진 거리(가까운지 탐지)
    }


}
public class BJ_16236 {
    static int n;
    static int[][] map;
    static boolean[][] visited ;

    //상어의 맨 처음 위치(크기는 2로 고정)
    static int start_x, start_y,pos_x,pos_y, time=0, size = 2;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //그래프 값 입력받기
        for(int i = 0; i<n; i++){
            st =  new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if(n == 9) {
                    start_x = i;
                    start_y = j;
                }
            }
        }

        //그래프에서 상어 값 이동시키며 탐색하기
        bfs(start_x, start_y);
        System.out.println(time);

    }
    public static void bfs(int x, int y){
        int eating = 0;//아기 상어가 먹은 물고기 개수
        pos_x = x;
        pos_y = y;
        
        while(true){
            Queue<Idx> q =  new LinkedList<>();
            List<Idx> list = new ArrayList<>();
            visited = new boolean[n][n];
            
            visited[pos_x][pos_y] = true;//먹이를 먹으면 그 기준으로 가까운 곳을 탐색해야하니까 list의 첫번쨰 부분인 가장 가까운 놈만 먹고 새로 갱신해서 다시 가까운 놈을 갱신함!!
            q.add(new Idx(pos_x,pos_y,0));//첫 탐색 시작

            //먹을 물고기가 있는지 탐색 -> 바로 옆칸에 없어도 멀리 있을 수 있음
            while(!q.isEmpty()){
                Idx idx = q.poll();
                int move_num = idx.move;

                //상하좌우 "탐색" 가능 - 찾아서 list와 큐에 저장함
                for(int i = 0; i<4; i++){
                    int nx = idx.x+dx[i];
                    int ny = idx.y+dy[i];

                    if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]){//map 안에 있는 조건
                        //해당 공간 탐색은 성공(탐색과 실제 이동은 다른 의미)
                        visited[nx][ny] = true;

                        //물고기가 "이동" 가능한 칸 인 경우
                        if(map[nx][ny] <= size){
                            if(map[nx][ny] !=0 && map[nx][ny] <size)//먹을 수 있는 경우(동적)
                                list.add(new Idx(nx,ny,move_num+1)); //한칸씩 이동하니까 move를 1씩 이동
                            q.add(new Idx(nx,ny, move_num+1));//이동한 칸의 개수를 누적 저장해야함 -> 상어위치를 갱신할때 몇 칸 이동했는지 정보 피룡
                        }
                    }
                }


            }//두번째 while문  //모두 살펴봤는데 먹이가 없을 경우 종료


            if(list.size() == 0) break;
            else {
                if(list.size() > 1)
                    list.sort(new MyComp());//가장 "가까운" 먹이를 찾아야하니까 정렬
            }

            //가까운 먹이를 찾았으니  걸린시간, 상어위치, 상어 크기 3가지를 재설정해준다.
            Idx first_eat = list.get(0);
            time = time+first_eat.move;
            eating++;//먹은 물고기 개수

            //상어 위치 와 크기 재설정
            map[pos_x][pos_y] = 0;//상어의 첫 위치였지만 떠남
            pos_x = first_eat.x;
            pos_y = first_eat.y;
            map[pos_x][pos_y] = 9;//상어 위치 재설정

            if(size == eating) {
                size++;//상어크기 1씩 증가
                eating = 0;//상어크기가 증가되면 초기화
            }


        }//첫번째 while 문
        
    }
    //어떤 물고기 위치가 가까운지 찾아주는 함수 -> comparable 사용 ->
    public static class MyComp implements Comparator<Idx>{
        @Override
        public int compare(Idx o1, Idx o2) {
            if(o1.move == o2.move){
                if(o1.x == o2.x){//가장 왼쪽
                    return o1.y-o2.y;//오름차순
                }
                return o1.x- o2.x;//가장 위쪽
            }
            else//아무런 조건이 없으면 그냥 가장 가까운 곳 탐색!
                return o1.move - o2.move;
        }

    }
}
