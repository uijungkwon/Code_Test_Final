package Binary_Search;//부품찾기_197p //"원소 자체"를 찾기
import java.util.*;

public class book_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //가게의 물건 개수와 부품 번호 입력
        int n = sc.nextInt();
        int[] store = new int[n];
        for(int i = 0; i<n; i++)
            store[i] = sc.nextInt();

        //손님의 부품 개수와 부품 번호 입력
        int m = sc.nextInt();
        int[] custom = new int[m];
        for(int i = 0; i<m; i++)
            custom[i] = sc.nextInt();

        //부품이 있는지 탐색 -> 이진탐색(빠르게)
        Arrays.sort(store);//먼저 정렬을 진행할 배열 정렬
        //m개의 손님 부품을 target으로 지정
        for(int i = 0; i<m; i++){
            boolean result =  binarySearch(store,custom[i],0,n-1);

            if(result) System.out.print("yes ");
            else System.out.print("no ");
        }

    }
    public static boolean binarySearch(int[] store, int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(store[mid] == target)
                return true;
            else if(store[mid]>target){
                end = mid-1;
            }
            else if(store[mid]<target){
                start = mid+1;
            }


        }

        return false;//다 탐색했는데 못 찾은 경우
    }
}
