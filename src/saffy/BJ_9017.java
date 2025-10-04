package saffy;
import java.util.*;
//2시간
//Map 객체를 만들고 관계성을 찾느라 많이 헤맸다.처음부터 조건을 넣어가며 분리시킨다.
class Score{
    int team;
    int rank;

    public Score(int team, int rank) {
        this.team = team; //나의 팀
        this.rank = rank; //전체 점수
    }
}
public class BJ_9017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        /*테스트 시작*/
        for(int i = 0; i<T; i++) {

            int N = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();//각팀 마다 6명있는 팀만 골라내기 위해 사용
            List<Integer> pass_team = new ArrayList<>();//골라낸 팀은 pass_team에 저장
            List<Score> list = new ArrayList<>();//전체 모든 사람의 등수 저장

            /*각 팀마다 명 수 세기*/
            for(int j = 1; j<=N; j++) {
                int team = sc.nextInt();
                list.add(new Score(team,0));
                map.put(team, map.getOrDefault(team, 0)+1);
            }

            /*팀이 6명이상인 팀 세기*/
            for(int val:map.keySet()) {
                if(map.get(val)==6)
                    pass_team.add(val);
            }

            /*점수 계산하기*/
            int cnt = 1;
            for(int j = 0; j<N; j++) {
                if(pass_team.contains(list.get(j).team)) {
                    list.get(j).rank = cnt;
                    cnt+=1;//다음사람의 점수 미리생성 (공동 등수는 없음)
                }
                else list.get(j).rank = -1;//점수 없다는 의미
            }

            /*등수 계산하기*/
            //왜 map을 사용했냐면 같은 key 끼리 즉 같은 팀끼리 값을 묶어주니까 여러개로 분류해서 다 사용해버림!! -> point
            //각 팀별로 4명까지를 세기 위한 tmp
            Map<Integer, Integer> tmp = new HashMap<>();//4명까지 개수
            //각 팀별로 4명까지의 점수 합을 구하기 위한 sum
            Map<Integer, Integer> sum = new HashMap<>();//4명까의 합
            //각 팀별로 5번째의 점수.를 위한 five
            Map<Integer, Integer> five = new HashMap<>();//5번째 점수


            /*등수 정하기*/
            for(int j = 0; j< list.size(); j ++) {//여기서 용어랑 key값 헷갈리지 않기!!
                if(pass_team.contains(list.get(j).team)) {
                    tmp.put(list.get(j).team, tmp.getOrDefault(list.get(j).team, 0)+1);

                    if(tmp.get(list.get(j).team)<=4) {
                        sum.put(list.get(j).team, sum.getOrDefault(list.get(j).team, 0)+list.get(j).rank);//누적합
                    }
                    else if(tmp.get(list.get(j).team) == 5) {
                        five.put(list.get(j).team, list.get(j).rank);
                    }
                }

            }

            /*최종 등수 정하기*/
            int min = (int)1e9;//초기화(최솟값 찾기)
            int min_team = 0;//등수 다 정하지 않고 1등만 찾으면 되므로 최소값만 찾기 OK!!

            for(int k: sum.keySet()) {
                if(min > sum.get(k)) {
                    min = sum.get(k);//최솟값 저장
                    min_team = k;//최솟값을 가진 팀 번호 저장
                }
                else if( min == sum.get(k)) {
                    if(five.get(k) < five.get(min_team))//5번째 점수로 비교
                        min_team = k;//해당 팀 번호 저장
                }
            }

            /*정답 출력*/
            System.out.println(min_team);

        }




    }
}
