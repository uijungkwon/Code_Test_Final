package Implementation;
import java.io.*;
import java.util.*;
public class test_10 {
    static int n, d=0;
    static int[][] map;
    static Map<Integer,String> moveInfo;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        moveInfo = new HashMap<>();
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            moveInfo.put(time, direction);
        }

        solve();
    }
    static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int time =0;
        int px =0;
        int py =0;

        while(true) {
            int nx = px + dx[d];
            int ny = py + dy[d];
            time++;

            // 벽 부딪힘
            if(nx<0 || ny<0 || nx>n-1|| ny> n-1) {
                break;
            }

            // 몸통 부딪힘
            if(q.contains(ny*n +nx)){
                break;
            }

            // 안 부딪히면 뱀 이동시작
            if(map[ny][nx] ==1) {//한 칸을 숫자 번호로 저장
                map[ny][nx] = 0;
                //System.out.println(ny*n +nx);
                q.add(ny*n +nx);
                //사과를 먹어서 길이가 1만큼 길어졌으므로// 꼬리를 가만히 두니까 그곳은 q에 넣기
            }else {
                q.add(ny*n +nx);
               // System.out.println(ny*n +nx);
                q.poll();//사과를 먹지 않았으므로 길이는 그대로니까 계속 빼기 그자리에 머물지 않고 이동하니까
            }

            // 방향 전환
            if(moveInfo.containsKey(time)) {
                String data = moveInfo.get(time);
                if(data.equals("D")) {
                    d +=1;
                    if(d==4)  d=0;
                }else {
                    d -=1;
                    if(d==-1) d=3;
                }
            }
            px = nx;
            py = ny;
        }
        System.out.println(time);
    }
}
