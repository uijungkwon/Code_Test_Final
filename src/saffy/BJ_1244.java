package saffy;
import java.util.*;
import java.io.*;
public class BJ_1244 {
    //60분
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*스위치 개수 및 스위치 입력*/
        int N = Integer.parseInt(br.readLine());
        int[] sw = new int[N+1];
        st= new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }

        /*학생 , 성별 및 받은 숫자 입력*/
        int s_num =Integer.parseInt(br.readLine());
        for(int i = 0; i<s_num; i++) {
            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());//성별
            int num  = Integer.parseInt(st.nextToken());//숫자
            change(s, num,sw,N);
        }
        /*정답 출력 20개 줄에 하나씩(정답 조건 철저히 확인할 것)*/
        for(int i = 1; i<=N; i++) {
            if(i % 20 ==1 && i>10)
                System.out.println();
            System.out.print(sw[i]+" ");
        }

    }
    public static void change(int s, int num, int[]sw, int N) {
        /*남자*/
        if(s ==1) {
            for(int i= 1;i<=N; i++) {
                if(i%num ==0) {
                    if(sw[i] ==0)sw[i] = 1;
                    else sw[i] = 0;
                }
            }
        }

        /*여자*/
        else {
            int a = num;
            int b = num;
            /*자기 자신은 무조건 변경*/
            if(sw[num] ==0) sw[num] = 1;
            else sw[num] = 0;

            while(true) {
                a = a-1;
                b = b+1;
                if(a<=0 || b>N)break;

                if(sw[a] == sw[b]) {//대칭이라면
                    if(sw[a] == 0) {
                        sw[a] = 1; sw[b] = 1;
                    }
                    else {
                        sw[a] = 0; sw[b] = 0;
                    }
                }
                else break;//비대칭일 경우 빠져나가기
            }

        }//else 문

    }

}
