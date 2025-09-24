package BackTrack;

import java.util.Scanner;

public class BJ_2447 {//Top_down 방식 구현
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//3의 거듭 제곱
        arr = new char[N][N];

        star(0,0,N,false);

        /*정답 출력*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void star(int x, int y, int N, boolean blank){
        if(blank){//4번째 구간일 때만
            for(int i = x; i<x+N; i++){
                for(int j = y; j<y+N; j++){
                    arr[i][j] = ' '; //별 대신 채워줌
                }
            }
            return;
        }

        if(N==1) {//이론상 N== 3까지만 구현해도 재귀조건에서 *을 반환해야할 마지노선 코드가 필요함 한칸씩 쪼개서 N==1일때 재귀 종료하도록 구현
            arr[x][y] = '*';
            return;
        }
        /*위의 상황이 아닐 경우 별로 채운다.*/
        int size = N/3;
        int count = 0;//새로 갱신
        for(int i = x; i<x+N; i+=size){//블럭으로 나누기
            for(int j = y; j<y+N; j+=size){ //모든 코드 다 확인
                count++;
                if(count ==5){//공백을 넣어야하는 구간
                    star(i,j,size,true);
                }
                else{//그 외엔 별 채우기
                    star(i,j,size,false);
                }
            }
        }


    }
}
