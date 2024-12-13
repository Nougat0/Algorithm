package baekjoon.resolved;

import java.io.*;
import java.util.*;
public class Main30979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("Padaeng_i ");
        StringTokenizer st;
        //입력
        int babysit = Integer.parseInt(br.readLine());
        int candy = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        //연산
        int eating = 0;
        for(int i=0; i<candy; i++) eating += Integer.parseInt(st.nextToken());
        //출력
        sb.append(eating >= babysit ? "Happy" : "Cry");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
