package saffy;
import java.util.*;
import java.io.*;

class Team implements Comparable<Team>{
    Map<Integer, Integer> score = new HashMap<>();//문제 별 점수
    int id;//팀 번호
    int count = 0;//문제 제출 횟수
    int time = 0;//마지막 문제 제출 시간
    int sum = 0;//총 점수
    int rank =0;
    /*같은 문제에 대해서 높은 점수만 넣어주기*/
    public void putter(int n,int s) {
        if(score.containsKey(n)) {
            if(score.get(n)<s) {
                score.put(n, s);
            }
        }
        else {
            score.put(n, s);
        }

    }

    @Override
    public int compareTo(Team t) {
        if(this.sum == t.sum) {
            if(this.count == t.count)
                return this.time - t.time;
            else return this.count - t.count;
        }

        else return t.sum - this.sum;
    }
}
public class BJ_3758 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*테스트(T) 횟수 입력*/
        int T = Integer.parseInt(br.readLine());

        /*테스트 진행*/
        for(int tc = 0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            /*팀 수(N), 문제 수(K),나의 팀 ID, 로그 엔드리(M)*/
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());//팀id는 번호로 생성
            int M = Integer.parseInt(st.nextToken());

            /*팀 객체 배열 초기화*/
            Team[] teams = new Team[N];
            for(int i = 0; i<N; i++) {
                teams[i] = new Team();//초기화
            }

            /*팀 ID,문제 번호, 획득 점수 입력 */
            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                teams[id-1].id = id;
                teams[id-1].putter(n,s);
                teams[id-1].count++;
                teams[id-1].time = i;//문제 제출한 시간을 계속 갱신 -> 클수록 늦은것
            }
            /*각 팀별 총점 확인하기*/
            for(int i = 0; i<N; i++) {
                Team t = teams[i];
                int sum = 0;
                for(int j:t.score.keySet()) {
                    sum+=t.score.get(j);
                    //System.out.println("팀 : "+(i+1)+" 문제: "+j+" 점수: "+t.score.get(j));

                }
                teams[i].sum = sum;//총점 넣기
            }
            //정렬
            Arrays.sort(teams);
            /*등수 입력*/
            int result = 0;
            for(int i = 0; i<N; i++) {
                if(teams[i].id == D)
                    System.out.println((i+1));
            }

        }

    }

}
