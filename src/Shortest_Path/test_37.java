package Shortest_Path;
import java.util.*;
import java.io.*;

public class test_37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] table = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++) {
                if(i == j)
                    table[i][j] = 0;
                else
                    table[i][j] = (int) 1e9;//최단거리 테이블 무한으로 초기화
            }
        }

        for(int i = 0;i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();//간선의 무게

            //중복되는 노선이 존재할 수 있음 -> 짧은 노선으로 저장
            if(table[a-1][b-1] > c)
                table[a-1][b-1]  = c;
        }

        //플로이드 워셜 알고리즘 적용하기
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    table[i][j] = Math.min(table[i][j], table[i][k]+table[k][j]);
                }
            }
        }
        /*
        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }*/

        //전체 최단거리 테이블 출력하기

        for(int i= 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(table[i][j] == (int)1e9)
                    System.out.print(0+" ");
                else
                    System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }

    }
}
