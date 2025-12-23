package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class BJ_2578 {
    static int[][]map;
    static boolean[][]visited;
    public static void main(String[] args)throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //StringTokenizer st ;

        /*빙고판 숫자 입력*/
        map = new int[5][5];
        visited = new boolean[5][5];
        for(int i = 0; i<5; i++){
            //st = new StringTokenizer(br.readLine());

            for(int j = 0; j<5; j++){
                int num = sc.nextInt();
                map[i][j] = num;
            }
        }
        /*사회자 게임 진행*/
        int result = 0;//최소 5회 이상
        for(int i = 0; i<25; i++){
            int num = sc.nextInt();
            result++;//사회자가 숫자를 부른 횟수

            /*빙고판 숫자 지우기*/
            find(num);

            /*빙고 개수 세기*/
            int count = check();
            /*3개이상의 빙고 완성하면 게임 중단 후 정답 출력*/
            if(count>=3) {
                System.out.println(result);//정답 출력
                break;//게임 중단
            }

        }
    }
    public static void find(int target){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(map[i][j] == target){
                    visited[i][j] = true;
                    return;
                }
            }
        }
    }
    public static int check(){
        int count = 0;//누적
        //가로
        for(int i = 0; i<5; i++){
            boolean chk =true;
            for(int j = 0; j<5; j++){
                if(!visited[i][j]){//false나오면 바로 break(불필요한 탐색 없애기)
                    chk = false;
                    break;
                }
            }
            if(chk)
                count++;
        }
        //세로
        for(int i = 0; i<5; i++){
            boolean chk =true;
            for(int j = 0; j<5; j++){
                if(!visited[j][i]){//가로 체크
                    chk = false;
                    break;
                }
            }
            if(chk)
                count++;
        }

        //대각선(2개)
        boolean chk =true;
        for(int i = 0; i<5; i++){
            if(!visited[i][i]){
                chk = false;
                break;
            }
        }
        if(chk)
            count++;


        chk =true;
        for(int i = 0; i<5; i++){
            if(!visited[i][4-i]){
                chk = false;
                break;
            }
        }
        if(chk)
            count++;


        return count;
    }
}
