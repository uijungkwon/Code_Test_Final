package saffy;
import java.util.*;
import java.io.*;
//22분

class Node {
    int w;//몸무게
    int h;//키
    int rank;

    public Node(int w, int h) {
        this.w = w;
        this.h = h;
    }


}

public class BJ_7568 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*사람 수, 몸무게와 키 입력*/
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Node(weight,height));

        }

        /*2중 for문으로 탐색*/

        for(int i = 0; i<N; i++) {
            int k = 0;
            Node now  = list.get(i);
            for(int j = 0; j<N; j++) {
                if(i == j )continue;

                Node other = list.get(j);
                if(now.w<other.w && now.h<other.h )
                    k++;

            }
            now.rank = k+1;
        }
        /*정답 출력*/
        for(int i = 0; i<N; i++) {
            System.out.print(list.get(i).rank+" ");
        }

    }

}

