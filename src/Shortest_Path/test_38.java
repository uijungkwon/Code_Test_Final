package Shortest_Path;
import java.util.*;
import java.io.*;

public class test_38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //학생수(N) 성적비교 횟수(M)입력
        int n =  sc.nextInt();
        int m = sc.nextInt();

        //학생들의 성적 관계를 나타내는 그래프 생성하기
        int[][] graph = new int[500][500];//최대학생수 : 500
        //그래프 초기화(무게 없는 양방향 그래프)
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j)
                    graph[i][j] = 0;
                else graph[i][j] = (int)1e9;
            }
        }
        //성적 비교 입력
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a-1][b-1] = 1;
        }

        //플로이드 워셜 알고리즘 실행
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        //양방향이 아닌 한방향만 있어도 순위 정할 수 있음
        int result = 0;
        for(int i = 0; i< n; i++){
            int cnt=0;
            for(int j = 0; j<n; j++){
                if(graph[i][j] != (int)1e9 || graph[j][i]!= (int)1e9){
                    cnt++;
                }
                else break;
            }
            if(cnt == n){
                result++;
            }
        }



        //임시 출력
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(graph[i][j] == (int)1e9)
                    System.out.print(0+" ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }

        //정답 출력
        System.out.println("정답"+ result); //예시에선 4번만 움직일 수 있음
    }
}
