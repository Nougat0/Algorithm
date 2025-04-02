package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        /*
        어쨌든 누군가가 안에 있어야 나올 수 있으니까
        단순히 in out 모두 더하기가 아님
        매 턴마다 [ 집안의 사람 수 >= 0 ] 이어야 한다
         */
        int in, out;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            int current = 0;
            int needed = 0;
            int m = Integer.parseInt(br.readLine());
            while(m-- > 0) {
                st = new StringTokenizer(br.readLine());
                in = Integer.parseInt(st.nextToken());
                out = Integer.parseInt(st.nextToken());
                if((in + current) < out) { //[1] 더 많이 나와버림 (이상현상)
                    needed += (out - (in + current)); //이상현상 수정
                    current = 0;
                } else { //[2] 모두 나왔거나 덜 나옴 (정상)
                    current += (in - out);
                }
            }
            sb.append(needed).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
