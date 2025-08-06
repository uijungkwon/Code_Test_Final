package Implementation;
import java.util.*;

public class test_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1) 문자열 입력
        String s = sc.next();
        ArrayList<Character> list  = new ArrayList<>();
        int sum = 0;

        //2) 문자열을 문자와 숫자로 분리
        for(int i = 0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){//숫자일 경우
                sum+=s.charAt(i)-'0';
            }
            else {
                list.add(s.charAt(i));
            }
        }
        Collections.sort(list);
        for(char c: list)
            System.out.print(c);
        System.out.println(sum);

    }
}
