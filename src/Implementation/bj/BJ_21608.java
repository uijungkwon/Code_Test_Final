package Implementation.bj;
import java.util.*;
import java.io.*;

class Seat implements Comparable<Seat>{
    int x;
    int y;
    int favorite;//인접한 칸의 좋아하는 학생 수 합
    int blank;//인접한 칸의 주변 빈칸 수 합

    public Seat(int x, int y, int favorite, int blank){
        this.x = x;
        this.y = y;
        this.favorite = favorite;
        this.blank = blank;
    }

    @Override
    public int compareTo(Seat o) { //우선순위 별로 "비교"하기 위해서 생성

        if (o.favorite == this.favorite) {
            if (o.blank == this.blank) {
                if (o.x == this.x)
                    return this.y - o.y;
                else return this.x - o.x;
            }

            else return o.blank - this.blank;
        }

        else return o.favorite - this.favorite;

    }
}
/*메인 함수*/
public class BJ_21608 {
    /*전역 변수 설정*/
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static int[][] graph ;
    static int n;//그래프 한 변
    static int[] student;//입력 순서대로 학생 번호 입력
    static Map<Integer,Set<Integer>> map = new HashMap<>();//학생 번호, 좋아하는 학생들 저장


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        /*변수 값 초기화*/
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        student = new int[n*n];

        for(int i= 0; i<n*n; i++){
            st= new StringTokenizer(br.readLine());
            /*학생 번호 입력 -> 학생 배열에 따로 저장*/
            student[i] = Integer.parseInt(st.nextToken());
            /*좋아하는 학생 4명 입력*/
            Set set = new HashSet();
            for(int j = 0; j<4; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            /*map에 학생 번호와 좋아하는 학생 함께 저장*/
            map.put(student[i], set);
        }

        /*자리 배정 시작*/
        int result = solution();

        /*결과 출력*/
        System.out.println(result);
    }
    public static int solution(){
        /*학생들 자리 배치*/
        //각 학생 번호 별로 원하는 자리 탐색
        for(int i= 0; i<n*n; i++){
            Seat seat = findSeat(student[i]);//학생번호에 맞는 좌석 객체를 찾아 반환
            graph[seat.x][seat.y] = student[i];//해당 좌표에 학생 넣기
        }
        //자리 배치 끝


        /*학생들 점수 합산 */
        int sum = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int num = getFav(graph[i][j], i, j);
                switch (num){
                    case 1:{
                        sum+=1;
                        break;
                    }
                    case 2:{
                        sum+=10;
                        break;
                    }
                    case 3:{
                        sum+=100;
                        break;
                    }
                    case 4:{
                        sum+=1000;
                        break;
                    }
                }//switch
            }
        }//for문

        return sum;
    }
    public static Seat findSeat(int student){//seat객체를 배열로 저장하지 않음 X -> 왜?
        Seat seat = null;
        /*한 학생의 자리를 찾을 때마다 graph의 모든 자리를 탐색하고 Seat 객체 생성 */
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(graph[i][j] >0)//이미 누군가 앉아 있다면
                    continue;
                //현재 자리에 대한 정보
                Seat cur = new Seat(i,j, getFav(student,i,j), getBlank(student,i,j));
                if(seat == null){//아예 아무것도 초기화되지 않은 칸이었다면,  새로 생성한 객체 값을 넣어줌
                    seat = cur;
                    continue;
                }

                if(seat.compareTo(cur) >0){//Math.max() 처럼 더 큰 값만 갱신함
                    //seat는 한번 초기화 된 값이고 cur은 모든 칸을 탐색하면서 인접한 칸을 많이 가진 최상의 칸을 찾고 "갱신"함 -> 마치 Math.max()같이 갱신
                    seat = cur;//갱신
                }

            }
        }


        return seat; //자리 배치 할 때만 사용하는 일회성
    }
    /*인접하는 좋아하는 사람 수 반환*/
    public static int getFav(int student, int x, int y){
        int count = 0;
        Set set = map.get(student);
        /*상하좌우 탐색-> 인접한거 찾으니까 1회만 */
        for(int i= 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && set.contains(graph[nx][ny])){//테두리 안에 들어오는 경우
                count++;
            }
        }
        return count;
    }

    /*인접하는 빈칸 수 반환*/
    public static int getBlank(int student, int x, int y){
        int count = 0;
        for(int i= 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && graph[nx][ny]==0){//테두리 안에 들어오는 경우
                count++;
            }
        }

        return count;
    }
}



