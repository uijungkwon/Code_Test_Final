package saffy;
import java.util.Scanner;
public class BJ_2816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        /*채널 수, 채널명 입력*/
        int N = sc.nextInt();
        String[] list = new String[N];
        for(int i = 0; i<N; i++) {
            list[i] = sc.next();
        }

        int idx = 0;
        /*kbs1정렬*/
        while(!list[0].equals("KBS1")) {

            String tmp=" ";
            if(idx>=0 && idx<N-1 && list[idx+1].equals("KBS1")) {
                tmp = list[idx];
                list[idx] = list[idx+1];
                list[idx+1] = tmp;

                sb.append(3);
                idx+=1;
            }
            else if(idx>0 && idx<=N-1 && list[idx-1].equals("KBS1")) {
                sb.append(2);
                idx-=1;
            }

            else if(list[idx].equals("KBS1")){
                tmp = list[idx];
                list[idx] = list[idx-1];
                list[idx-1] = tmp;

                sb.append(4);
                idx-=1;
            }
            else {
                sb.append(1);
                idx+=1;
            }



        }

        /*kbs2정렬*/
        while(!list[1].equals("KBS2")) {
            String tmp=" ";
            if(idx>=0 && idx<N-1 && list[idx+1].equals("KBS2")) {
                tmp = list[idx];
                list[idx] = list[idx+1];
                list[idx+1] = tmp;

                sb.append(3);
                idx+=1;
            }
            else if(idx>0 && idx<=N-1 && list[idx-1].equals("KBS2")) {
                sb.append(2);
                idx-=1;
            }

            else if(list[idx].equals("KBS2")){
                tmp = list[idx];
                list[idx] = list[idx-1];
                list[idx-1] = tmp;

                sb.append(4);
                idx-=1;
            }
            else {
                sb.append(1);
                idx+=1;
            }


        }



        System.out.println(sb);
        //why?
    }

}
