package Binary_Search;
import java.util.*;
import java.io.*;

public class test_28 {//고정점 찾기
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];

        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();//정렬된 상태
        }

        int answer = binary(0,nums.length-1);
        System.out.println(answer);
    }
    static public int binary(int start, int end){

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] < mid)
                start = mid+1;
            else if(nums[mid] == mid)
                return mid;
            else end = mid-1;

        }
        return -1;

    }
}
