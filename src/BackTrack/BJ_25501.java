package BackTrack;
import java.util.*;

public class BJ_25501 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i<T; i++){
            String str = sc.next();

            count = 0;
            int result = isPalindrome(str);


            /*is반환값, recursion반환값 출력*/
            System.out.println(result+" "+count);
        }



    }
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;//펠린드롬
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
