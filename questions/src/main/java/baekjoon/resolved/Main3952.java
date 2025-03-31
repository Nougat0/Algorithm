package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            char[] line = br.readLine().toCharArray();
            int length = line.length;
            int characters = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int cursor = 0;
            while(characters-- > 0) {
                //상대적 인덱스값(cursor) 입력 및 조정
                cursor += Integer.parseInt(st.nextToken());
                if(cursor >= length) cursor -= length;
                else if(cursor < 0) cursor += length;
                sb.append(line[cursor]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
