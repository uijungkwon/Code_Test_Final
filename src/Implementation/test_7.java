package Implementation;//럭키스트레이크
import java.util.*;
public class test_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String s_l  = s.substring(0,s.length()/2);
        String s_r  = s.substring(s.length()/2);

        int sum_l =0;
        int sum_r = 0;

        for(int i= 0; i<s.length()/2; i++){
            sum_l+=s_l.charAt(i);
            sum_r+=s_r.charAt(i);
        }
        if(sum_l == sum_r) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
