package Binary_Search;
import java.util.*;
import java.io.*;
public class test_27 {//정렬된 배열에서 특정 수의 개수 구하기
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        nums = new int[n];
        for(int i = 0; i< n ; i++){
            nums[i] = sc.nextInt();
        }
        //이진탐색에서 상한가, 하한가 찾기
        if(binary(x) == 0)
            System.out.println(0);
        else System.out.println(binary(x));

    }
    static public int binary(int x) {
        //각각의 범위에서 이진 탐색 진행
        int left = lower(0, nums.length - 1, x);//start, end,타겟
        int right = upper(0, nums.length - 1, x);
        System.out.println("left = "+left+", right = "+right);
        return (right - left);
    }
    public static int lower(int start, int end, int x){
        while(start<end){//타겟을 찾는게 아니라 상한가
            int mid = (start+end)/2;
            if(nums[mid] >= x){
                end = mid-1;
            }
            else start = mid+1;//x보다 클 경우
        }
        return end;
    }
    public static int upper(int start, int end, int x){//중간에 반환하지 않고 끝까지 탐색 후 반환
        while(start<end){//타겟을 찾는게 아니라 상한가
            int mid = (start+end)/2;
            if(nums[mid] <= x){
                start = mid+1; //중간에 반환하는 것이 아니라 "범위"만 구함!!!
            }
            else end =  mid;//타겟보다 클 경우
        }

        return end;
    }
}