package saffy;
import java.util.*;
import java.io.*;
//60분
class Room{
    int m;//최대 정원
    String[] nickname;//얘만 사전식으로 배열하기
    int[] level;
    int start_lv;
    int count;//들어갈 자리 가리키는

    //새로운 방을 만들었을 때에만 배열 크기 입력,
    public Room(int m,String nick,int lv,int start_lv) {

        this.m = m;//기준 정원

        nickname = new String[m];
        nickname[0] = nick;

        level= new int[m];
        level[0]  =lv;

        this.start_lv = start_lv;

        this.count = 1;//생성자 함수
    }

    public void put(int lv, String nick) {//원소 넣기
        nickname[count] = nick;
        level[count] = lv;
        count++;
    }

    public void room_print() {
        /*닉네임 순서대로 출력*/
        Integer[] idx = new Integer[count];
        for (int i = 0; i < count; i++) idx[i] = i;
        //여기서 a와 b는 순서대로 비교해준다/
        Arrays.sort(idx, (a,b) -> nickname[a].compareTo(nickname[b]));


        /*Arrays.sort(idx, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		return a.compareTo(b);//사전식에서 오름차순 정렬
        	}
        });
        Arrays.sort(idx, (a,b)->a.compareTo(b)); //for문처럼 숫자를 입력하는게 아니라 idx 처음부터탐색하면서 조건에 따라 탐색함
        */

        for (int i : idx) {
            System.out.println(level[i] + " " + nickname[i]);
        }
    }
    public int full() {
        if(count == m)//count는 다음 값을 가리킴
            return 1;
        else return 0;//더 넣을 수 있음
    }



}

public class BJ_20006 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*모든 사용자 레벨과 닉네임 입력*/
        List<Room>list = new ArrayList<>();

        for(int i = 0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int lv = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();

            int j = 0;

            for(j = 0; j<list.size(); j++) {
                int score = list.get(j).start_lv;//기준 레벨
                if(lv >=(score-10) && lv<=(score+10) && list.get(j).full()==0) {
                    list.get(j).put(lv,nick);
                    break;
                }
            }
            /*모두 탐색했는데 못들어가는 경우*/
            if(j==list.size())
                list.add(new Room(M,nick,lv,lv));

        }
        /*모든 방을 돌면서 게임이 시작하는지 확인!*/
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).full()==1)
                System.out.println("Started!");
            else System.out.println("Waiting!");

            list.get(i).room_print();
        }
    }

}
