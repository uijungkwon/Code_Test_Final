package data_structure;
import java.util.*;
import java.io.*;
class Paper implements Comparable<Paper>{
    int idx;//0부터
    int priority;//1부터
    public Paper(int idx,int priority){
        this.idx =idx;
        this.priority = priority;
    }
    @Override
    public int compareTo(Paper p){
        return p.priority - this.priority;//내림차순 정렬(큰 수 부터)
    }
}
public class BJ_1966 {
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        /*테스트 케이스 시작*/
        for(int T = 0; T<tc; T++){
            /*문서개수 N, 찾으려는 문서의위치 M입력*/
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int myPri =0;//내가 뽑고자하는 위치의 중요도

            Queue<Paper> q = new LinkedList<>();//(위치, 중요도) 저장
            List<Integer> pri = new ArrayList<>();//중요도 저장 -> 참고용

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                int priority = Integer.parseInt(st.nextToken());
                if(i == M)
                    myPri = priority;//M 위치에 있는 중요도를 저장

                /*내림차순으로 중요도를 나타내는 리스트 따로 생성*/
                pri.add(priority);
                q.offer(new Paper(i,priority));
            }

            Collections.sort(pri, Collections.reverseOrder());//중요도가 큰 순서대로 저장(내림차순)

            int result = 0;//M위치에 있는 문서가 뽑힌 순서
            boolean chk = false;//result를 찾았는지의 유무

            for(int i = 0; i<N; i++) {
              /*중요도 탐색*/
                int priority = pri.get(i);//중요도 하나씩 꺼냄
                while(q.peek().priority!=priority){
                    /*priority가 가장 앞에 올때까지 회전*/
                    q.offer(q.poll());
                }
                /*가장 앞에 있는 값이 나의 중요도랑 같은지 확인*/
                if(q.peek().priority == myPri){
                    /*인덱스가 M과 같은지 확인*/
                    if(q.peek().idx == M){
                        result = i+1;
                        chk = true;
                        break;
                    }
                    else q.offer(q.poll());
                }
                else q.poll();
                if(chk)break;
            }
            sb.append(result).append('\n');
        }
        /*정답 출력*/
        System.out.println(sb);
    }
}
