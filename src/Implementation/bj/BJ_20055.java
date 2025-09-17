package Implementation.bj;
import java.util.*;
import java.io.*;
/*
* 시뮬레이션 문제에서 가장 중요한 점 : 기준점 이나 범위나 제시되는 작은 조건들을 간과하지 말것
* */
public class BJ_20055 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[2*n];//내구도 저장(쭉 폈을 때를 상상)
        boolean[] robot = new boolean[n];//로봇은 위에 벨트에만 놓을 수 있으니 n개만 나타낼 수 있음

        //내구도 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<2*n;i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        //시뮬레이션 시작
        int result = 1;

        while(true){
            //1. 벨트가 각 칸 위에 있는 "로봇과 함께" 한 칸 회전한다.(배열 이동으로 구현)
            /*벨트 이동*/
            int temp = belt[2*n-1];
            for(int i= 2*n-1; i>0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = temp;
            /*로봇 이동(회전 구현과 같음)*/
            for(int i = n-1; i>0; i--){
                robot[i] =robot[i-1];//있냐 없냐 하는 불린 값으로 지정
            }
            robot[0] = false;//옆으로 이동했기 때문
            robot[n-1] = false;//언제든지 내리는 위치에 도달하면 즉시 내린다.

            //2. 가장 먼저 벨트에 올라간(맨 끝쪽의 로봇)로봇부터 벨트 회전 방향으로 한칸 이동한다.(불가능하면 가만히 있는다)
            for(int i = n-1; i>0; i--){
                //이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1이상 남아있어야한다//
                if(robot[i-1] && !robot[i] && belt[i]>=1){//예시에서 내리는 자리에는 사람 없으니까
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i] = belt[i]-1;
                }
            }

            //3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(belt[0]>0) {
                robot[0] = true;
                belt[0]--;
            }

            //4.내구도가 0인 칸의 개수가 k개이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int cnt = 0;
            for(int i = 0; i<2*n; i++){
                if(belt[i] ==0) cnt++;
            }

            if(cnt>=k)break;

            result++;
        }
        System.out.println(result);
    }
}
