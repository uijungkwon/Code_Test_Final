package saffy;
import java.util.*;
import java.io.*;

class Medal implements Comparable<Medal>{
    int country;
    int gold;
    int silver;
    int brown;

    public Medal(int country, int gold, int silver,int brown)
    {	this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.brown = brown;
    }
    @Override
    public int compareTo(Medal o) {
        if(this.gold == o.gold) {
            if(this.silver == o.silver)
                return this.brown - o.brown;
            else return this.silver - o.silver;
        }

        return this.gold- o.gold;
    }
}

public class BJ_8979 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Medal> list = new ArrayList<>();

        for(int i= 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Medal(num,a,b,c));

        }

        Collections.sort(list);
        for(int i = 0; i<list.size(); i++) {
            if(K == list.get(i).country)
                System.out.println(i);//순위
        }

    }

}
