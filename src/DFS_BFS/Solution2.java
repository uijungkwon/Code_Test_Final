package DFS_BFS;
import java.util.*;

class Node4{
    int x;
    int y;
    int dis;

    Node4(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
class Solution {

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        //탐색
        q.offer(new Node4(0,0,1));//첫 위치

        while(!q.isEmpty()){
            Node4 node = q.poll();
            int x = node.x;
            int y = node.y;
            int d = node.dis;

            if(x == n-1 && y == m-1) return d; //마지막 좌표 나온 순간 반환

            for(int i = 0 ; i<4; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];



                if(nx>=n||ny>=m ||nx<0||ny<0||visited[nx][ny]||maps[nx][ny]==0)continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx,ny,d+1));

            }


        }




        answer = -1;
        return answer;
    }
}