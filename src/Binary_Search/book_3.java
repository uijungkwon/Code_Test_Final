package Binary_Search;//떡볶이떡 만들기_201p

import java.util.*;
public class book_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //떡의 개수N과 요청한 떡의 길이 M이 주어진다.
        int n = sc.nextInt();
        int m = sc.nextInt();//최소 합으로 구함

        int[]nums = new int[n];
        for(int i = 0; i<n; i++)
            nums[i] = sc.nextInt();
        Arrays.sort(nums);

        //m만큼의 합을 구할 수 있는 높이의 최댓값 구하기
        int result=  binary(nums,0,nums[n-1], m);
        System.out.println(result);

    }
    public static int  binary(int[] nums, int start, int end, int m){
        int h = 0;

        while(start<=end){//끝까지 탐색해서 최댓값 찾음(찾았을 때 미리 저장해야함
            int mid = (start+end)/2;
            int sum = 0;

            //임의의 mid값으로 떡들을 자른 후 떡의 양 확인하기
            for(int i= 0 ;i<nums.length; i++){
                if(nums[i]>mid)
                    sum+= nums[i]-mid;
            }

            if(sum>=m){
                start = mid+1;
                h = mid;
            }
            else if(sum<m){//모자라면 아예 정답이 될 수 없음
                end = mid-1;
            }
            else break;//정확한 값을 찾으면 반환


        }

        return h;//모두 탐색 한 후 최대한 덜 잘랐을 때가 정답
    }
}
