package BackTrack;
import java.io.*;

public class BJ_4779 {
    static char[] A ;
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb ;

        while ((str = br.readLine()) != null){
            /*num : 배열의 크기*/
            int n = Integer.parseInt(str);
            int num = (int)Math.pow(3,n);
            A = new char[num];//배열 매번 새롭게 갱신
            sb = new StringBuilder();

            for(int i= 0 ;i<num; i++){
                A[i] = '-';//초기화
            }
            canto(0, num);

            /*결과 출력*/
            for(int i = 0; i<num; i++){
                sb.append(A[i]);//계속 해서 출력하면 입출력 버퍼 발생
            }
            sb.append("\n");

            System.out.print(sb);
        }
    }
    public static void canto(int start, int size){//문자열의 구간
        /*재귀가 멈추는 조건*/
        if(size ==1){
            return;//이미 갱신
        }

        int newSize = size/3;
        for(int i = start+newSize; i<start+2*newSize; i++){
            A[i] = ' ';//공백 집어넣어 갱신
        }

        /*재귀를 통해 1이 남을 때까지 갱신*/
        canto(start, newSize);//왼쪽
        canto(start+2*newSize, newSize);//오른쪽

    }

}
