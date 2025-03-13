package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18679 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int words = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<String, String> dict = new HashMap<>();
        while(words-- > 0) {
            String[] translate = br.readLine().split(" = ");
            dict.put(translate[0], translate[1]);
        }
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            int wordsInSentence = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                sb.append(dict.get(st.nextToken())).append(' ');
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
