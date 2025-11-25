package data_structure;
import java.util.*;
import java.io.*;

public class BJ_5430 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t<tc; t++){
            boolean result = true;
            boolean chk = true; //기본 : 왼 -> 오

            String order = br.readLine();
            int N = Integer.parseInt(br.readLine());//숫자 개수
            Deque<Integer> dq = new ArrayDeque<>();
            //List<Integer> list = new ArrayList<>();
            String s = br.readLine();
            s = s.substring(1,s.length()-1);//양쪽 대괄호 제거
            String[] nums = s.split(",");//콤마로 숫자 나누기

            /*nums를 숫자로 변환하여 list에 삽입*/
            for(int i = 0; i<N; i++){
                dq.offer(Integer.parseInt(nums[i]));
            }
            /*명령문 수행*/
            for(int i= 0; i<order.length(); i++){
                char c = order.charAt(i);
                if(c =='D'){
                    if(dq.isEmpty())
                        result = false;
                    else {
                        if(chk)
                            dq.pollFirst();
                        else dq.pollLast();
                    }
                }
                else chk = !chk;

            }

            /*남은 배열 출력문 저장*/
            if(result){
                sb.append("[");
                while(!dq.isEmpty()){
                    if(chk){
                        sb.append(dq.pollFirst());
                    }
                    else{
                        sb.append(dq.pollLast());
                    }

                    if(dq.size() !=0)
                        sb.append(",");
                }
                sb.append("]").append("\n");
            }
            else sb.append("error").append('\n');
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
