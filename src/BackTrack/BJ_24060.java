package BackTrack;
import java.util.*;
import java.io.*;

public class BJ_24060 {
    /*재귀를 활용하여 정렬 사용*/
    static int N,K;
    static int cnt=0;//저장 횟수 누적
    static int result = -1;
    static int[] tmp ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*배열 A의 크기 N, 저장 횟수 K 입력*/
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        /*병합 정렬로 A를 오름차순으로 정렬*/
        int[] A = new int[N];
        tmp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }


        merge_sort(A,0,N-1);
        /*A에 k번째 저장되는 수를 구해라*/
        System.out.println(result);
    }

    public static void merge_sort(int[] A, int p, int r){
        /*A배열을 오름차순 정렬한다.*/
        //재귀 막는 조건
        if(cnt >K) return;//조건 채우면 더이상 진행 X

        if(p<r){ //재귀 진행
            int q = (p+r)/2;
            merge_sort(A,p,q);//전반부 정렬(오름차순)
            merge_sort(A,q+1, r);//후반부 정렬(오름차순)
            merge(A,p,q,r);//정렬한 것 병합

        }

    }
    public static void merge(int[] A, int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = 0;//내가 임시로 저장할 배열 (첫번째부터 채워주기)


        while(i<=q && j<=r){
            if(A[i]<=A[j]){
                tmp[t++] = A[i++];
            }
            else {
                tmp[t++] = A[j++];
            }
        }
        while(i<=q){//왼쪽 배열부분이 남은 경우
            tmp[t++] = A[i++];
        }
        while(j<=r){//왼쪽 배열부분이 남은 경우
            tmp[t++] = A[j++];
        }
        i =p;
        t =0;
        while(i<=r){//결과 저장 -> 이때 횟수 누적
            cnt++;
            if(cnt == K){
                result = tmp[t];
            }
            A[i++] = tmp[t++];//결과값 저장
        }

    }

}
