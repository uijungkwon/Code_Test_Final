package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
/**
 * 판을 자를 때(범위 안에서): 시작점, 끝점(시작점+크기)
 *
 * */
public class BJ_1018 {
    static boolean[][] arr ;
    public static int min = 64;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new boolean[row][col]; //T,F 값으로 저장

        /*보드 상태 입력*/
        for(int i = 0; i< row; i++){
            String str = br.readLine();
            for(int j = 0; j<col; j++){
                if(str.charAt(j) =='W')
                    arr[i][j] = true;
                else arr[i][j] = false;
            }

        }
        /*보드를 8x8 형태 체스판으로 자르기*/
        for(int i = 0; i< row-7; i++){//행 시작 꼭짓점
            for(int j = 0; j<col-7; j++){//열 시작 꼭짓점
                find(i,j);
            }
        }
        System.out.println(min);//최소 변경해야 하는 판의 개수
    }

    private static void find(int x, int y) {//(x,y)시작 꼭짓점
        int count = 0;

        boolean TF = arr[x][y];//맨 왼쪽 위 칸의 색상 흰 OR 검 기준!

        for(int i = x; i<x+8; i++){//"시작점 부터 8칸"이지, 8번까지 체크하는게 아님!!
            for(int j = y; j<y+8; j++){
                if(arr[i][j] !=TF)
                    count++;//고쳤을 때
                TF = (!TF);
            }
            TF = !TF;//다음 줄은 시작 색이 반대이기 때문에
        }
        count = Math.min(count, 64-count);//전체 다 바꿀 경우가 64임, 오른쪽은 반대 색깔을 기준으로 했을 때의 색깔(8*8 = 64가 전체 판을 다 바꿨을 때니까!)
        min = Math.min(min,count);//여러 판으로 잘랐을 때의 min값 구하기
    }

}
