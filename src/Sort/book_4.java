package Sort;//두 배열의 원소 교체_183p
import java.util.*;
public class book_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        Integer[] b = new Integer[n];

        for(int i= 0; i<n; i++)
            a[i] = sc.nextInt();
        for(int i = 0; i<n; i++)
            b[i] = sc.nextInt();
        //a배열은 오름차순, b배열은 내림차순으로 정렬
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        //k번만큼 원소 바꿔치기
        int result= 0;
        for(int i = 0; i<k; i++){
            a[i] = b[i];
        }
        for(int i= 0; i<n; i++)
            result+=a[i];

        System.out.println(result);
    }
}
