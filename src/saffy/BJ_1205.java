package saffy;
import java.util.*;
//60분
class Sing implements Comparable<Sing>{
    int num = 0;
    int rank =0; //본인 값과 이전값을 비교하고 싶을 때 객체를 생성해서 해당값의 연산을 사용한다!

    public Sing(int num, int rank) {
        this.num = num;
        this.rank = rank;//비교를 위해서 객체의 요소 설정
    }
    @Override
    public  int compareTo(Sing s) {//비교와 정렬의 기본
        return s.num - this.num;
    }
}

public class BJ_1205 {
    /*문제에서 제시한 숫자들의 개수와 제한되어있는 배열의 크기가 다름 -> 조건문 사용*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*변수 입력*/
        int N = sc.nextInt();
        int new_score = sc.nextInt();
        int P = sc.nextInt();
        List<Sing> ranking = new ArrayList<>();
        int result = 0;

        /*점수들 입력(내림차순)*/
        for(int i = 0; i<N; i++) {
            ranking.add(new Sing(sc.nextInt(),0));
        }

        /*랭킹 리스트가 꽉 찼을 경우*/
        if(N == P) {
            if(ranking.get(N-1).num >=new_score) {
                System.out.println(-1);
                System.exit(0);
            }

            else {
                ranking.add(new Sing(new_score, 0));
                Collections.sort(ranking);
                ranking.remove(ranking.size()-1);
            }


        }

        /*랭킹 리스트가 널널할 경우*/
        else if(N < P) {//새로운 점수 "한 개"만 넣을 거임
            ranking.add(new Sing(new_score, 0));
            Collections.sort(ranking);
        }

        /*점수를 랭킹에 다 넣었으니 등수를 정하면 된다.*/
        //1등은 반드시 존재 첫번째 객체는 1등으로 초기화
        int count = 0;//공동 등수 체크(공동등수 명 만큼 다음 등수를 더해야하므로 논리 세우기)
        ranking.get(0).rank = 1;
        int idx = (ranking.get(0).num == new_score)? 0:-1;//아니라면 -1번으로 초기화
        for(int i= 1; i<ranking.size(); i++) {
            if(ranking.get(i).num == new_score)
                idx = i;

            if(ranking.get(i-1).num >ranking.get(i).num) {
                ranking.get(i).rank = ranking.get(i-1).rank+1+count;
                count = 0;//초기화 //ex) 1,2,2,4

            }
            else if(ranking.get(i-1).num == ranking.get(i).num) {
                ranking.get(i).rank = ranking.get(i-1).rank;
                count++;//겹친 공동등수 만큼 세주기
            }
        }


        /*정답 출력*/
        System.out.println(ranking.get(idx).rank);
    }

}
