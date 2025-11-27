package data_structure;
import java.util.*;
import java.io.*;
//5분
public class BJ_10816 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num))
                sb.append(map.get(num)).append(" ");
            else sb.append(0).append(" ");
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
