package data_structure;
import java.util.*;
import java.io.*;//48분
public class BJ_1406 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  ;

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        /*문자가 담긴 뎈 초기화*/
        Deque<Character> dq = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();//떨어진 애들 담아내는 용도
        for(int i = 0; i<str.length(); i++){
            dq.offer(str.charAt(i));
        }

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch(s){
                /*커서(pos) 왼쪽 이동*/
                case "L":{
                    if(!dq.isEmpty())
                        stack.push(dq.pollLast());
                    break;
                }
                case "D":{
                    if(!stack.isEmpty())
                        dq.offerLast(stack.poll());
                    break;
                }
                case "B":{
                    if(!dq.isEmpty()) {
                        dq.pollLast();
                    }
                    break;
                }
                case "P":{
                    String x = st.nextToken();
                    dq.offerLast(x.charAt(0));//한 글자 추가
                    break;
                }
            }
        }
        /*정답 출력*/
        StringBuilder sb= new StringBuilder();
        while(!dq.isEmpty())
            sb.append(dq.pollFirst());
        while(!stack.isEmpty())
            sb.append(stack.poll());
        System.out.println(sb);
    }
}
