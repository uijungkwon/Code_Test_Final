package DFS_BFS;
class Solution {
    public String solution(String p) {
        String answer = "";
        //1.입력이 빈 문자열인 경우, 빈 문자열 반환
        if(p.equals(""))return answer;

        //2.문자열 p를 u와 v로 분리
        int i = balance(p);
        String u = p.substring(0,i+1);
        String v = p.substring(i+1);

        //3. 수행한 결과 문자열을 u에 이어붙인 후 반환한다.
        if(correct(u))
            answer = u + solution(v);//재귀함수 호출
        else{
            answer = answer+'(';
            answer = answer + solution(v);
            answer = answer + ')';
            u = u.substring(1, u.length()-1);

            for(int j = 0; j<u.length(); j++){
                if(u.charAt(j) == '(')
                    answer+=')';
                else answer+='(';
            }
        }


        return answer;
    }

    //균형잡힌 문자열인지 확인해 주는 함수
    public static int balance(String w){
        int count = 0;
        for(int i = 0; i<w.length(); i++){
            char c = w.charAt(i);
            if(c == '(')count++;
            else count--;

            if(count == 0) return i;
        }
        return -1;//균형 잡히지 않은 경우 
    }
    //올바른 문자열인지 확인해 주는 함수(이미 균형 잡혀 있다.)
    public static boolean correct(String p){
        int count = 0;
        for(int i = 0; i< p.length(); i++){
            if(p.charAt(i) =='(') count ++;
            else{
                if(count ==0)return false;//중간에 0이 나와버리면 합이 맞지 않음
                count --;
            }

        }
        return true;

    }
}