package DFS_BFS.BJ;
import java.util.*;
import java.io.*;
public class BJ_14889 {
    static int N;
    static int[][] power;
    static boolean[] visited;
    static int min =(int)1e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];//N명의 회원이 T,F에 속해있는지 확인
        power = new int[N][N];
        /*N명의 능력치 입력*/
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*두 팀 나누기*/
        team(0,0);

        /*정답 출력*/
        System.out.println(min);
    }
    public static void team(int depth, int start){
        if(depth == N/2){
            /*팀 별 능력 점수 차이 구함*/
            diff();
            return;//재귀 종료
        }
        for(int i = start; i<N; i++){
            if(!visited[i]){
                visited[i] = true;//팀을 나눈 거임
                team(depth+1, i+1);
                visited[i] = false;//전체 배열에서 T,F체크하고 있기 때문에 원상 복귀 안해주면, 값이 중복됨(r개만큼 output을 사용하는것이 아니라 전체 배열을 사용하고 있기 때문에!)
            }
        }
    }
    public static void diff(){
        int teamA = 0;
        int teamB = 0;

        /*N명의 회원 의 소속 팀 확인 후, 해당 팀에 능력치 누적*/
        for(int i = 0; i<N-1; i++){ //이중 탐색
            for(int j = i+1; j<N; j++){
                if(visited[i] == true && visited[j] == true){
                    teamA+=power[i][j]+power[j][i];
                }
                else if(visited[i] == false && visited[j] == false){
                    teamB+=power[i][j]+power[j][i];
                }
            }
        }
        if(Math.abs(teamA-teamB) == 0) {
            System.out.println(0);
            System.exit(0); //이게 최솟값이므로 더 찾을 필요도 없음
        }
        /*최솟값 누적*/
        min = Math.min(min, Math.abs(teamA-teamB));
    }
}
