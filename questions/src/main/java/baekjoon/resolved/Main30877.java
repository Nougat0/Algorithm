package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30877 {
    /*
        https://www.acmicpc.net/problem/30877
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final int N = Integer.parseInt(br.readLine());
        String line;
        char c;
        for(int row=1, i=0; row<=N; row++, i=0) {
            st = new StringTokenizer(br.readLine());
            line = st.nextToken();
            //ArrayIndexOutOfBounds 는 발생하지 않는다 (x, X를 그 전에 만나므로)
            while((c = line.charAt(i)) != 'x' && c != 'X') i++;
            c = st.nextToken().charAt(i);
            if(c >= 'a') c -= 'a' - 'A'; //대문자로 변환
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
