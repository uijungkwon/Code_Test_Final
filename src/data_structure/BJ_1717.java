package data_structure;
import java.util.*;
import java.io.*; //40분//
public class BJ_1717 {
    static int[] parent;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*N과 M 입력*/
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*집합 번호와 연결 유무를 나타낸 "배열"생성 */
        parent = new int[N+1];
        for(int i = 0; i<=N; i++){
            parent[i] = i;
        }

        /*M회 연산*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(cal == 0)//집합 연산
                union(n1,n2);
            else {//부모 찾기
                if(findParent(n1) == findParent(n2)) //부모가 같으면 같은 덩어리에 속함
                    sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }

        /*정답 출력*/
        System.out.println(sb);
    }
    public static void union(int n1, int n2){
        /*n1과 n2의 부모 먼저 찾기(어떤 덩어리랑 연결되어있는지)*/
        int a = findParent(n1);
        int b = findParent(n2);

        if(a<b)
            parent[b] = a;//"작은 번호"를 부모로 주입한다=> 내가 만든 규칙
        else parent[a] = b;
    }
    public static int findParent(int num){
        if(parent[num]== num)
            return num;//이값 찍으면 갖고 올라옴
        return parent[num] = findParent(parent[num]); //경로 압축
        //탐색할때는 순차적으로 찾아가도록 구현해놨는데, 제일 최상위 "부모"를 찾으면 나머지 자식들도 같은 숫자로 바꿔버림 -> 그래야 나중에 같은 집합에 있ㄴ는지 parent 값 보고 바로 확인가능!!
    }
}
