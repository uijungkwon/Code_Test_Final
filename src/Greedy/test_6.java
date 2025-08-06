package Greedy;//무지의 먹방 라이브
import java.util.*;
class Food implements Comparable<Food>{
    int index;
    int time;

    public Food(int index, int time){
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Food o) {//적게 걸리는 시간부터 정렬
        return this.time - o.time;
    }
}
class Solution{
    public int solution(int[] food_times, long k){
        int answer = 0;
        //전체 음식을 먹는 시간보다 k가 크거나 같다면 -1(오류나기 전에 다 먹어버림(
        long summary = 0;
        for(int i= 0; i< food_times.length; i++){
            summary+=food_times[i];
        }
        if(summary >=k) return -1;

        //시간이 작은 음식부터 빼야하므로 우선순위 큐를 이용한다.
        Queue<Food> pq = new PriorityQueue<>();
        for(int i = 0; i< food_times.length; i++){
            pq.offer(new Food(i+1,food_times[i] ));
        }
        summary = 0;//먹기 위해 사용한 시간
        long prev = 0;//직전에 다 먹은 음식 시간
        long length = food_times.length;;//남은 음식의 개수

        while(summary + ((pq.peek().time - prev) * length) <= k){//1초당 1씩 음식을 먹으니까 갱신!
            int now = pq.poll().time;//현재 먹는 음식의 시간
            summary = summary + (now - prev)*length;
            length--;
            prev = now;//지금 먹었던게 이젠 직전에 먹은 음식으로 리셋

        }
        ArrayList<Food> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        //음식의 번호 기준으로 정렬(가까운 번호 부터 섭취하니까)
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.index, b.index);
            }
        });
        return result.get((int) ((k - summary) % length)).index;


    }
}
