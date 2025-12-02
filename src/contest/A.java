package contest;
import java.util.*;
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = str.charAt(0);

        String result ="";
        switch(c){
            case 'F': {
                result = "Foundation";
                break;
            }
            case 'C': {
                result = "Claves";
                break;
            }
            case 'V': {
                result = "Veritas";
                break;
            }
            case 'E': {
                result = "Exploration";
                break;
            }

        }
        System.out.println(result);
    }
}
