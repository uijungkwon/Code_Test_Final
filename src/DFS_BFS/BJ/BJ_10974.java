package DFS_BFS.BJ;

import java.util.Scanner;

public class BJ_10974 {
    static int[] output;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        output = new int[N];
        visited = new boolean[N];

        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = i+1;
        }
        perm(0,N,arr);

    }
    public static void perm(int depth, int n, int[]arr){
        if(depth == n){
            for(int i= 0; i<n; i++)
                System.out.print(output[i]+" ");
            System.out.println();
            return;
        }
        for(int i= 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                perm(depth+1, n, arr);
                visited[i] = false;//원상복귀 //체크해야함
            }
        }

    }
}
