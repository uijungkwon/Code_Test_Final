package contest;
import java.util.*;

public class D {//25분
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int x = 0;
        switch(s.charAt(0)){
            case 'a':{
                x = 1;
                break;
            }
            case 'b':{
                x = 2;
                break;
            }
            case 'c':{
                x = 3;
                break;
            }
            case 'd':{
                x = 4;
                break;
            }
            case 'e':{
                x = 5;
                break;
            }
            case 'f':{
                x = 6;
                break;
            }
            case 'g':{
                x = 7;
                break;
            }
            case 'h':{
                x = 8;
                break;
            }

        }
        int y = Character.getNumericValue(s.charAt(1));

        int[] dx = {1,-1,1,-1,2,-2,2,-2};
        int[] dy = {2,2,-2,-2,1,1,-1,-1};

        /*가능한 경로 모두 탐색*/
        int result = 0;
        for(int i = 0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=1 && nx<=8 && ny>=1 && ny<=8)result++;
        }
        System.out.println(result);
    }
}
