package data_structure;
import java.util.*; //14분
public class BJ_7785 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        /*N개의 출입기록 작성*/
        Set<String> set = new HashSet<>();
        for(int i = 0; i<N; i++){
            String name = sc.next();//이름
            String check = sc.next();//출입 유무

            if(check.equals("enter"))
                set.add(name);
            else set.remove(name);
        }

        /*정답 출력*/
        StringBuilder sb = new StringBuilder();
        List<String> names = new ArrayList<>();
        for(String s: set)
            names.add(s);
        Collections.sort(names, Collections.reverseOrder());

        for(int i =0; i<names.size(); i++)
           sb.append(names.get(i)).append('\n');

        System.out.println(sb);
    }
}
