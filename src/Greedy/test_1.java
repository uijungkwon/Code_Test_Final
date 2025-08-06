package Greedy;//모험가 길드 311p
import java.util.*;
public class test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1)모험가(N명) 와 공포도 입력
        int n = sc.nextInt();
        Integer[]horror = new Integer[n];
        for(int i= 0; i<n; i++)
            horror[i] = sc.nextInt();

        //2)공포도 내름차순 정렬
        Arrays.sort(horror, Collections.reverseOrder());

        //3) 최대 모험가 그룹 구할 수 있는 경우 찾기
        int max = horror[0];//초기화
        int count = 0;
        int group = 0;

        for(int i = 0; i<n; i++){
            count++;
            if(max == count){
                group++;//하나의 그룹 완성
                if(i+1 < n)
                    max = horror[i+1];//새로운 최대값 갱신하기
                count = 0;
            }
        }

        System.out.println(group);
    }
}
