package Greedy;
import java.util.*;
public class test_2 {
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1) 문자열 입력
        String s = sc.next();
        //2) 각 하나의 숫자로 분리하여 int 형 배열에 넣기
        nums = new int[s.length()];
        for(int i = 0; i<s.length(); i++)
            nums[i] = s.charAt(i)-'0';
        //3) 두 연산자를 이용해서 모든 숫자의 조합을 찾기 -> 그중 최댓값 고르기
        //0일 때만 덧셈하고 나머지는 곱셈을 해야 최대값 찾아짐
        int sum =0;
        for(int i= 0; i<nums.length; i++){
            if(nums[i]<=1 || sum <=1)
                sum+=nums[i];
            else sum*=nums[i];
        }

        //4) 정답 출력
        System.out.println(sum);
    }

}
