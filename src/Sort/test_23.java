package Sort;
import java.util.*;
import java.io.*;

class Score implements Comparable<Score>{
    String name;
    int lang;
    int eng;
    int math;
    public Score(String name, int lang, int eng, int math){
        this. name = name;
        this.lang = lang;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Score o) {
        if(this.lang == o.lang) {
            if(this.eng == o.eng){
                if(this.math == o.math)
                    return this.name.compareTo(o.name);
                return o.math-this.math;
            }
            return this.eng - o.eng;
        }


        return o.lang -this.lang ;
    }
}
public class test_23 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Score[] scores = new Score[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            scores[i] = new Score(s,a,b,c);

        }
        Arrays.sort(scores);
        for(int i = 0; i< n; i++){
            System.out.println(scores[i].name);
        }
    }
}
