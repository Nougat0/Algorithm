package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9038 {
    /*
        https://www.acmicpc.net/problem/9038
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            int width = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int space = width;
            int lines = 1;
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                int length = word.length();
                if(space == width) { //첫 단어
                    space -= length;
                } else { //첫 단어 이상 (앞에 공백(+1) 포함시킴)
                    if(space < length+1) { //공간부족 -> 다음 줄 넘어가기
                        lines++;
                        space = (width - length); //다음 줄의 첫 단어
                    } else {
                        space -= (length+1);
                    }
                }
            }
            sb.append(lines).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
