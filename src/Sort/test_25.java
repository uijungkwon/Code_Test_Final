package Sort;
import java.util.*;
class node implements Comparable<node>{
    @Override
    public int compareTo(node o) {
        return 0;
    }
}

class Solution {
    static Map<Integer,Double> map ;
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int size = stages.length;//사용자 수
        map = new HashMap<>();

        //0) stages 오름차순 정렬
        Arrays.sort(stages);

        //1) N개의 스테이지 탐색하기
        for(int i = 1; i<=N ; i++){
            //실패율 : (N/N이상 stages의 수)
            double cnt = 0; //스테이지에 도달한 사용자
            double clear = 0;//스테이지에 도달하지 못한 사용자

            //모든 게임 사용자의 스테이지 번호 탐색
            for(int j = 0; j<size; j++){
                if(stages[j]>=i) {
                    cnt++;
                    if(stages[j] == i)
                        clear++;
                }
            }
            if(clear ==0 || cnt == 0)
                map.put(i,0.0);
            else
                map.put(i,(clear/cnt));//스테이지번호, 실패율 함께 저장
        }

        //2) 스테이지 번호들을 list로 저장하여 내림차순으로 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, new MyComp());
        for(int i = 0 ; i<N; i++){
            //정렬한 스테이지 번호들을 answer에 저장
            answer[i] = keySet.get(i);
        }

        //3) 정답 반환
        return answer;
    }
    class MyComp implements Comparator<Integer>{//기본형 비교

        @Override
        public int compare(Integer d1, Integer d2){
            if(map.get(d1) == map.get(d2))
                return d1.compareTo(d2);
            return map.get(d2).compareTo(map.get(d1));
        }
    }
}
