package Implementation.bj;
import java.util.*;
import java.io.*;
public class BJ_14890 {
    static int N,L;
    static int[][] map ;
    static int[] copy;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L= Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int road_row = 0;
        //행 탐색
        for(int i = 0; i<N; i++){
            copy = new int[N];
            for(int j=0; j<N; j++){
                copy[j] = map[i][j]; //한 행 복사
            }
            if(check(copy)) {
                //System.out.println("행 : "+i);
                road_row++;
            } //길이 존재하면 갈 수 있는 경로의 수 누적
        }

        //열 탐색
        int road_col = 0;
        for(int i = 0; i<N; i++){
            copy = new int[N];
            for(int j=0; j<N; j++){
                copy[j] = map[j][i];
            }
            if(check(copy)) {
                //System.out.println("열 : "+i);
                road_col++;
            } //길이 존재하면 갈 수 있는 경로의 수 누적
        }

        //정답 출력
        //System.out.println("행: "+road_row +", 열: "+road_col);
        System.out.println(road_col+road_row);
    }
    //길이 존재하는지 탐색하는 함수
    public static boolean check(int[] arr){
        int floor = 1;//낮은 층고의 연속된 개수를 세는 변수
        boolean btn = false; //높게 올라갔을 경우 체크 //높은 층고보단 낮은 층고의 연속된 개수를 생각해야하니 boolena값으로 체크만 해놓고
        for(int i = 1; i<N; i++){

            if(arr[i-1] == arr[i]){
                floor++; //연속된 낮은 계단의 개수
            }
            else if(arr[i-1] > arr[i]){//내려가는 계단
                if(!btn && arr[i-1] - arr[i] ==1){
                    btn = true;
                    floor = 1;//초기화
                }
                else return false;

            }//내려가는 계단

            else if(arr[i-1] < arr[i]){//올라가는 계단
                if(arr[i]-arr[i-1] ==1 && floor >= L){
                    floor = 1;//초기화
                }
                else return false;
            }//올라가는 계단
//-------------------------

            if(btn && floor==L){//내려가는 계단으로 처리 완료
                btn = false; //완성되면 다시 처리해주거든
                floor = 0;//처리 완료
            }

        }//for문 끝
        //항상 for문이 끝나더라도 남아있는 값을 확인해야할 경우에는 조건문 처리
        if(btn && floor<L) {//내려오는 계단 //마지막 부분 처리
            return false;
        }

        return true;
    }
}
