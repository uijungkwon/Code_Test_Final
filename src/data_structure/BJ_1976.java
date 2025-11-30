package data_structure;
import java.util.*;
import java.io.*; //30분
public class BJ_1976 {
    static int[] parent;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*도시의 수 N*/
        int N = Integer.parseInt(br.readLine());
        /*여행할 도시의 수 M*/
        int M = Integer.parseInt(br.readLine());

        /*N개의 도시 간 연결 정보-> map 형태로 제공*/
        parent = new int[N+1];//1번부터 N번으로표시
        /*부모 배열 초기화*/
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                int chk = Integer.parseInt(st.nextToken());
                if(chk == 1){/*union*/
                    union(i,j);
                }
            }
        }
        /*여행 가능한지 여부 확인하기*/
        st = new StringTokenizer(br.readLine());
        int check = parent[Integer.parseInt(st.nextToken())];//집합 번호 초기화
        boolean result = true;

        for(int i = 0; i<M-1; i++){
            int x = Integer.parseInt(st.nextToken());//여행지 입력
            if(check != parent[x]){
                result = false;break;
            }
        }

        /*정답 출력*/

        if(result) System.out.println("YES");
        else System.out.println("NO");
    }
    public static int findParent(int num){
        if(parent[num] ==num)//재귀 종료 조건
            return num;
        else return parent[num] = findParent(parent[num]);//왜 다시 대입하냐면 부모를 찾고 되돌아 올때 "부모의 숫자"로 통일시켜야 다음번에 찾을때 '한번에 '찾음
    }
    /*두 개의 집합 합치기*/
    public static void union(int i, int j){
        /*부모 찾기*/
        int a = findParent(i);
        int b = findParent(j);//같은 부모면 한 집합에 있다는거 확정

        if(a<b)
            parent[b] = a;
        else
            parent[a] = b;

    }
}
