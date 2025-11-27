package data_structure;
import java.util.*; //7분
public class BJ_1764 {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);

        /*A집합의 사람 수 N, B집합의 사람 수 M 입력*/
        int N = sc.nextInt();
        int M = sc.nextInt();

        /*A집합 입력*/
        Set<String> A = new HashSet<>();
        for(int i = 0; i<N; i++){
            A.add(sc.next());
        }
        /*B집합 입력과 동시에 교집합 확인*/
        List<String> list= new ArrayList<>();
        for(int i= 0; i<M; i++){
            String name = sc.next();
            if(A.contains(name))
                list.add(name);//교집합이라면 list에 저장

        }
        /*사전순서로 출력*/
        Collections.sort(list);//기본형 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for(int i = 0; i<list.size(); i++){
            sb.append(list.get(i)).append('\n');
        }
        /*정답 출력*/
        System.out.println(sb);
    }
}
