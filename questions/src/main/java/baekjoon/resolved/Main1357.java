package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] x = st.nextToken().toCharArray();
        char[] y = st.nextToken().toCharArray();

        char[] result = String.valueOf(rev(x) + rev(y)).toCharArray();
        bw.write(rev(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int rev(char[] number) {
        StringBuilder sb = new StringBuilder();
        for(int i=number.length-1; i>=0; i--) {
            sb.append(number[i]);
        }
        return Integer.valueOf(sb.toString());
    }
}
