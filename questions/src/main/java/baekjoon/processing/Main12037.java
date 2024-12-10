package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main12037 {
    private static long[] factorial = new long[100000];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int c, v, l; //c:consonant(자음), v:vowel(모음), l:length(길이)
        //자음 뒤에는 무조건 모음이 붙어줘야 한다
        //자음끼리 붙을 수 없다
        //자음 혼자 사용 불가 -> 모음은 얼마든지 사용 가능
        for(int t=0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            //모음만 조합한 수
            long validWords = 0;
            validWords += Math.pow(v, l);
            //자음 포함 (자음+모음) -> 2자리 차지하는 새로운 모음
            for(int i=1; i<=l/2; i++) {//i:포함할 자음 개수(종류X)
                long factor = 1, addWords = c*v;
                if(l-i > 1) {
                    factor = getFactorial(l-i);
                    //자음이 들어갈 자리는 구분되지 않으므로 같은 것 정렬 제거 -> /2 해줘야 함
                    //나머지 모음 자리들의 조합 곱해주기
                    addWords *= (long) (factor/2 * Math.pow(v, l-i));
                }
                validWords += addWords;
            }
            sb.append("Case #").append(t+1).append(": ").append(validWords % 1000000007).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 팩토리얼 값 구하는 재귀함수
     * @param n 팩토리얼 수
     * @return n!
     */
    public static long getFactorial(int n) {
        if(factorial[n] != 0) { //값이 있을 시
            return factorial[n];
        } else if(n <= 1) { //1이거나 0
            factorial[n] = 1;
            return 1;
        } else { //1보다 큰 수의 팩토리얼 구하기
            long result = n * getFactorial(n-1);
            factorial[n] = result;
            return result;
        }
    }
}
