package data_structure;
import java.util.*;
import java.io.*;

public class BJ_20920 {
    static Map<String,Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            if(str.length()<M) continue;

            map.put(str, map.getOrDefault(str,0)+1);
        }
        List<String> list = new ArrayList<>();
        for(String s:map.keySet())
            list.add(s);

        Collections.sort(list, new MyComp());

        /*정답 출력*/
        StringBuilder sb = new StringBuilder();
        for(String s:list)
            sb.append(s).append('\n');
        System.out.println(sb);


    }
    public static class MyComp implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            //단어 카운트가 높은게 이미 전제 되어야함.=> 순서대로 3가지 우선순위 체크
            if(map.get(a) == map.get(b)){
                if(a.length() == b.length())
                    return a.compareTo(b);//기본 String형(사전식)
                else return b.length() - a.length();
            }
            else return map.get(b).compareTo(map.get(a));//내림 차순
        }
    }
}
