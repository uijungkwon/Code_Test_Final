package Greedy;
import java.util.*;
public class test_4 {
    static Set<Integer> set = new HashSet<>();
    static int n;
    static int sum = 0;
    static int[] coin;
    static int[] output;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1)N 과 동전의 화폐단위 입력
        n = sc.nextInt();
        coin = new int[n];
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            coin[i] = sc.nextInt();
        }
        //2) 탐색(모든 뽑는 경우의 수 생각하기)

        for(int i = 1; i<=n; i++){
            output = new int[i];
            comb(0,0,n,i);
        }

        //숫자 1부터list의 끝값까지 확인하며 최소 숫자를 출력한다.
        for(int i = 1; i<=1000; i++){
            if(set.contains(i))
                continue;
            else {
                System.out.println(i);
                break;
            }
        }
    }
    public static void comb(int start, int depth, int n, int m){//n중에 m개뽑음
        if(depth == m){
            for(int i =0; i<m; i++){
                sum+=output[i];
            }
            set.add(sum);
            sum = 0;
            return;
        }
        for(int i = start; i<n; i++){
            //sum += coin[i];
            output[depth] = coin[i];
            comb(i+1, depth + 1, n, m);
        }

    }
}
