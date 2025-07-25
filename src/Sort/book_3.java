package Sort;
import java.util.*;//성적이 낮은 순서대로 출력하기
class student implements Comparable<student>{
    String name;
    int age;
    public student(String name, int age){
        this.name = name;
        this.age = age;
    }
    //성적순서대로 오름차순 정렬

    @Override
    public int compareTo(student o) {
        return this.age-o.age;
    }
}
public class book_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//학생 수
        student[] students = new student[n];

        //학생들 정보 입력
        for(int i = 0; i<n; i++){
            String name = sc.next();
            int age = sc.nextInt();
            students[i] = new student(name,age);
        }
        //성적이 낮은 순서대로 학생들의 이름을 출력한다
        Arrays.sort(students);
        for(int i = 0; i<n; i++){
            System.out.print(students[i].name+" ");
        }
    }
}
