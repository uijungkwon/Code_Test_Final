package saffy;
import java.util.*;
import java.io.*;

public class BJ_11723 {
    //15분
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        Set<Integer> copy = new HashSet<>();
        for(int i = 0 ; i<=20 ; i++) {
            copy.add(i);
        }

        int num = 0;
        for(int i =0; i<M; i++) {
            st  = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(!str.equals("all") && !str.equals("empty"))
                num = Integer.parseInt(st.nextToken());

            switch(str) {
                case "add":{
                    set.add(num);
                    break;
                }
                case "remove":{
                    set.remove(num);
                    break;
                }
                case "check":{
                    if(set.contains(num))
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                }
                case "toggle":{
                    if(set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);
                    break;
                }
                case "all":{ //숫자 필요 없음
                    set = copy;
                    break;
                }
                case "empty":{
                    if(!set.isEmpty())
                        set.clear();
                    break;
                }


            }//switch

        }//for


        /*결과 출력*/
        System.out.println(sb);
    }

}