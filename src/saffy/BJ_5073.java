package saffy;
import java.util.*;
import java.io.*;
//40분 -> 삼각형 반례 조건
public class BJ_5073 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] tri;
        while(true) {
            st = new StringTokenizer(br.readLine());

            tri = new int[3];
            tri[0] = Integer.parseInt(st.nextToken());
            tri[1] = Integer.parseInt(st.nextToken());
            tri[2] = Integer.parseInt(st.nextToken());

            if(tri[0] == 0 && tri[1] == 0 && tri[2] == 0)break;

            Arrays.sort(tri);

            if(tri[0]+tri[1] >tri[2]) {
                if(tri[2] == tri[1] && tri[1] == tri[0]) {
                    sb.append("Equilateral").append('\n');
                }
                else if(tri[2] == tri[1] || tri[1] == tri[0] || tri[2] == tri[1] && tri[2] == tri[0]){
                    sb.append("Isosceles").append('\n');//이등변 삼각형의 종ㄹ
                }
                else sb.append("Scalene").append('\n');

            }
            else sb.append("Invalid").append('\n');


        }



        System.out.println(sb);
    }

}
