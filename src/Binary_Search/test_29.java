package Binary_Search;
import java.util.*;
import java.io.*;

public class test_29 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();//집 개수
        int c = sc.nextInt();//공유기 개수

        int[] house = new int[n];
        for(int i = 0; i<n; i++){
            house[i] =sc.nextInt();
        }
        Arrays.sort(house);

        //탐색 시작
        int start = 1;//가능한 최소 "거리"
        int end = house[n-1];//가능한 "최대 거리" //거리 기준 으로 정렬
        int result = 0;

        while(start<=end){
            int mid = (start+end)/2;// 중간 위치
            int last = house[0];//첫번째 집에는 무조건 공유기 설치
            int cnt = 1;//설치한 공유기 개수

            // 현재의 mid 값을 이용해 공유기를 설치하기
            for (int i = 1; i < n; i++) { // 앞에서부터 차근차근 설치// 전체 경우의 수를 탐색  (mid구할 때마다 설치 할 수있는 공유기 개수 탐색)
                if (house[i] >= last + mid) {//공유기는 "집 위치"에만 설치 할 수 있음
                    last = house[i];
                    cnt += 1;
                }
            }
            //공유기 충분히 설치 -> 너무 빨리 설치 -> 거리 늘리기
            if (cnt >= c) {
                start = mid + 1;
                result = mid; // 최적의 결과를 저장
            }
            // 공유기 조금 설치 -> 너무 느리게 설치 -> 거리 줄이기
            else {//아직 공유기 다 설치 못함
                end = mid - 1;
            }


        }

        System.out.println(result);
    }
}
