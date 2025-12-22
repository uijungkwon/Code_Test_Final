package DFS_BFS.BJ;
import java.util.*;
import java.io.*;

public class BJ_3085 {
    static char[][] candy;
    static int N;
    static int max = -(int)1e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        /*사탕 입력(종류: C,P,Z,Y)*/
        candy = new char[N][N];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                candy[i][j] = str.charAt(j);
            }
        }

        /*최대 사탕 개수 출력*/
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N-1; j++){//조건에 해당 된다면, 오른쪽과 아래 모두 이용가능하므로 둘다 if문 작성
                /*인접한 "두 칸"만 변경 => 오른쪽, 아래 스위치만 하면됨*/
                //1) 오른쪽 이동
                if(j+1<N){
                    //바꾸기
                    swap(i,j,i,j+1);
                    //길이 계산
                    len(candy);
                    //원상 복귀
                    swap(i,j+1,i,j);
                }

                //2) 아래로 이동
                if(i+1<N){
                    //바꾸기
                    swap(i,j,i+1,j);
                    //길이 계산
                    len(candy);
                    //원상 복귀
                    swap(i+1,j,i,j);
                }
            }
        }

        /*정답 출력*/
        System.out.println(max);
    }
    public static void swap(int x, int y, int nx, int ny){//카피하지 말고 원상 복ㄱ
        char tmp = candy[x][y];
        candy[x][y] = candy[nx][ny];
        candy[nx][ny] = tmp;
    }
    public static void len(char[][] copy){/*인접한 두 칸을 교환*/
        /*행 탐색*/

        for(int i = 0; i<N; i++){
            int count = 1; //행 달라져도 갱신
            for(int j = 0; j<N-1; j++){
               if(copy[i][j] == copy[i][j+1])//연속으로 같으면 저장
                   count++;
               else {
                   //최대 연결된 길이 갱신 후 원상 복귀
                   max = Math.max(max, count);
                   count = 1;
               }
            }
            max = Math.max(max, count);
        }

        /*열 탐색*/
        for(int i = 0; i<N; i++){
            int count = 1;
            for(int j = 0; j<N-1; j++){
                if(copy[j][i] == copy[j+1][i])//연속으로 같으면 저장
                    count++;
                else {
                    //최대 연결된 길이 갱신 후 원상 복귀
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

    }

}
