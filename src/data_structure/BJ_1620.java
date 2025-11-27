package data_structure;
import java.util.*;
public class BJ_1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*N,M 입력*/
        int N= sc.nextInt();
        int M = sc.nextInt();

        /*N개의 원소가 담긴 도감 생성*/
        Map<Integer, String> map = new HashMap<>();
        Map<String,Integer > map2 = new HashMap<>();
        for(int i = 1; i<=N; i++){
            String name = sc.next();
            map.put(i, name);
            map2.put(name,i);
        }

        /*M개의 캐릭터 찾기*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++){//도감에 있는 애만 입력
            /*입력이 문자열인지 숫자인지 판별*/
            String search = sc.next();
            if(Character.isDigit(search.charAt(0))){//맨 앞 글자만 확인
                //숫자라면
                int num = Integer.parseInt(search);
                sb.append(map.get(num)).append('\n');
            }
            else{
                //문자열이라면
                sb.append(map2.get(search)).append('\n');
            }
        }

        /*정답 출력*/
        System.out.println(sb);
    }
}
