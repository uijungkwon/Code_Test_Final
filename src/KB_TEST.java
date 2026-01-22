import java.util.*;
import java.io.*;

public class KB_TEST {
    //원형 탁자에서 최소 거리 구하기
    public class Main {
        public static int shortestDistance(int N, int S, int E) {
            int direct = Math.abs(S - E);//크고 작은거 말고 차이값 구함(절댓값 구하기_
            int round = N - direct;//
            return Math.min(direct, round);//둘중에 최솟값 구하리
            //매주 한개씩 풀자~~^^ 매우 기본적인 수학 계산 단계
        }


        public static void main(String[] args) {
            int N = 10;
            int S = 2;
            int E = 9;
            System.out.println(shortestDistance(N, S, E)); // 3
        }
    }
}
