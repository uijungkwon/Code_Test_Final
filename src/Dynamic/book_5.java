package Dynamic;
import java.util.*;


public class book_5 {
    static int INF = (int)1e9;//최단 경로 처럼 찾기 전까진 무한대 못찾으면 무한으로 냅둠
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1)화폐종류(N)과 목표 금액(M)을 입력 받는다
        int n = sc.nextInt();
        int m = sc.nextInt();

        //2) 화폐 종류를 입력 한다.
        int[] category = new int[n];
        for(int i = 0; i<n; i++)
            category[i] = sc.nextInt();
        Arrays.sort(category);//오름차순 정렬

        //3) dp 테이블을 만든다.
        int[] dp = new int[10001];
        //테이블 무한대로 초기화
        for(int i  = 0; i<=m; i++)
            dp[i] = INF;
        //최소 화폐 개수를 찾는다.
        dp[0] = 0;
        for(int i = 0; i<category.length; i++){
            int k  = category[i];//(2,3,5) 종류의 화폐가 있다면 하나씩 살펴보고 갱신
            for(int j = 1; j<=m; j++){
                if(j-k>=0)
                    dp[j] = Math.min(dp[j], dp[j-k]+1);//누적 합
            }
        }

        //정답 출력
        if(dp[m] == INF) System.out.println(-1);
        else System.out.println(dp[m]);
    }
}
