package saffy;
import java.util.*;
//60분
public class BJ_2512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*지방의 수 와 예산 금액 입력*/
        int N = sc.nextInt();
        int[] price = new int[N];
        long sum = 0;int max = -1;

        for(int i = 0; i<N; i++) {
            price[i] = sc.nextInt();

            sum+=price[i];
            max = Math.max(max, price[i]);
        }

        /*예산 총액 입력*/
        long total = sc.nextLong();

        int result = 0;
        /*모든 요청 배정 가능한 경우*/
        if(sum<=total)
            result = max;

            /*모든 요청 배정이 불가능한 경우*/
        else {
            /*상한액 할당*/
            Arrays.sort(price);//오름차순 정렬
            result = binary(price,price[0],price[N-1],total);
        }
        /*정답 출력*/
        System.out.println(result);
    }
    public static int binary(int[] arr, int left, int right, long total) {
        int result = 0;
        while(left<=right) {
            int mid = (left+right)/2;
            long sum = 0;
            for(int i = 0; i<arr.length; i++) {
                if(arr[i]<mid)
                    sum+=arr[i];
                else
                    sum+=mid;
            }

            if(sum>total) {//왼쪽이동
                right = mid-1;
            }
            else if(sum<total) {//오른쪽 이동//정답에 해당하는 숫자(최댓값 구하기)
                left = mid+1;
                result = mid;//while조건문이면서 sum<total해당하는 상한값을 미리 저장
            }
            else {
                return mid;//상한액 바로 반환
            }
        }


        return result;//상한액 반환//최댓값 찾기
    }

}