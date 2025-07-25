package Sort;
import java.util.*;

public class book_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums, Collections.reverseOrder());
        for(int i= 0;i<n; i++)
            System.out.print(nums[i]+" ");
    }
}
