package Graph;//팀 결성 //전형적인 서로소 집합 문제
import java.util.*;
import java.io.*;
public class book_2 {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1) 학생 번호(N), 연산 개수(M) 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 0; i<=n; i++)
            parent[i] = i;

        //2) m개의 연산 입력 받기 (0 : 합치기, 1: 같은 팀 확인)
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(num == 0) union(a,b);

            else if( num == 1){
                if(parent[a] == parent[b])
                    System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }
    static public int find(int num){
        if(parent[num] == num)
            return num;
        else return parent[num] = find(parent[num]);
    }
    static public void union(int n1, int n2){
        int a = find(n1);
        int b = find(n2);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
}
