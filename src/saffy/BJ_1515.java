package saffy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1515 {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int pt = 0;

        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);//두자리 이상 30000 미만으로 숫자가 증가하니까
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pt))
                    pt++;
                if (pt == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new BJ_1515().solution();
    }
}