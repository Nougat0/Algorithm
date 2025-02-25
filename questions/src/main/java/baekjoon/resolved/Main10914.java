package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10914 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    /*
        변형된 카이사르 암호
    */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //단어별 확인
        while(st.hasMoreTokens()) {
            char[] word = st.nextToken().toCharArray();
            int length = word.length, index = 0;
            //2개 글자 단위로 확인, 여분 버리기
            while(index+1 < length) { 
                // 'a' -> 0 으로 환산하고, 최종 결과(x)는 'a' 다시 추가
                // n을 빼기 때문에 최종 x 값이 영하가 될 수도 있음 = 'a'-'z' 범위 벗어남
                // -> n의 최대값 이상 + 결과값에 영향을 안 미치는 26을 더함
                char letter = (char) ((word[index] + word[index+1] - n + 26 - 'a'*2) % 26 + 'a');
                sb.append(letter);
                index += 2;
            }
            sb.append(' ');
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}
