package Implementation;
import java.io.*;
import java.util.*;

public class bj_14891 {
    static int[][] data = new int[4][8];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++) {
            String line = br.readLine();
            for(int j=0; j<8; j++) {
                data[i][j] = line.charAt(j)-'0';
            }
        }

        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            gearOperation(idx,dir);
        }

        int total =0;
        for(int i=0; i<4; i++) {
            total += Math.pow(2, i)*data[i][0];
        }
        System.out.println(total);
    }

    static void gearOperation(int idx, int dir) {//(3,-1)
        // 왼쪽 (0 ~ idx-1)
        leftSide(idx-1, -dir);
        // 오른쪽 (idx+1 ~ 3)
        rightSide(idx+1, -dir);
        //위에서 회전시킨 놈들은 나를 포함하지 않음
        //따라서 마지막으로 한번더 내 자신을 회전시킴
        rotation(idx,dir);//회전시킴//내가 원하고자 하는 톱니바퀴는 일단 물리적으로 옮겨야됨
        //그때 양극이 맞다면 옆에 놈들이 옮겨지는것이라서 위에서 재귀탐색 후 맨 마지막에 내 자신을 옮기는 거임
    }

    static void leftSide(int idx, int dir) {
        if(idx < 0) return;
        if(data[idx][2]==data[idx+1][6]) return;//배열 범위에 벗어나지 않게 조정
        leftSide(idx-1, -dir);//바뀌는 톱니가 있는지 재귀함수를 통해 끝까지 탐색
        rotation(idx,dir);//두 함수 재귀의 조합
    }

    static void rightSide(int idx, int dir) {
        if(idx > 3) return;
        if(data[idx][6] == data[idx-1][2]) return;
        rightSide(idx+1, -dir);
        rotation(idx,dir);
    }

    static void rotation(int idx, int dir) {
        if(dir==1) {
            int tmp = data[idx][7];
            for(int i=7; i>0; i--) {
                data[idx][i] = data[idx][i-1];
            }
            data[idx][0] = tmp;
        }else {
            int tmp = data[idx][0];
            for(int i=0; i<7; i++) {
                data[idx][i] = data[idx][i+1];
            }
            data[idx][7] = tmp;
        }
    }
}