package saffy;
import java.util.*;
//51분
public class BJ_20125 {
    /*Tip)
     * 심장의 i,j 위치를 중심으로 다른 물체의 중심 찾기 (중심을 잡아야 뻗어나갈 수 있다.)
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*판의 길이 입력*/
        int N = sc.nextInt();
        int heart_x = 0;
        int heart_y = 0;
        int arm_l = 0;
        int arm_r = 0;
        int back =0;
        int leg_l = 0;
        int leg_r = 0;
        boolean first = false;

        for(int i = 1; i<=N; i++) {
            String str = sc.next();
            for(int j = 1; j<=N; j++) {
                char c = str.charAt(j-1);
                if(c== '*') {
                    /*심장 찾기*/
                    if(!first) {
                        first = true;
                        heart_x = i+1;
                        heart_y = j;

                    }
                    /*팔의 길이 측정*/
                    if(i == heart_x && j<heart_y) {
                        arm_l+=1;
                    }
                    else if(i == heart_x && j>heart_y) {
                        arm_r+=1;
                    }
                    /*허리 길이 측정*/
                    else if(i > heart_x && j== heart_y) {
                        back+=1;
                    }
                    /*왼쪽 다리 길이 측정*/
                    else if( j == heart_y-1) {
                        leg_l +=1;
                    }
                    else if( j == heart_y+1) {
                        leg_r +=1;
                    }
                }

            }
        }



        /*정답 출력*/
        System.out.println(heart_x+" "+heart_y);
        System.out.println(arm_l+" "+arm_r+" "+back+" "+leg_l+" "+leg_r);

    }
}