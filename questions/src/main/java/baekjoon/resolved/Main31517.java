package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main31517 {
    /*
        https://www.acmicpc.net/problem/31517
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int problems = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());
        while(problems-- > 0) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            if(min <= level && max >= level) level++;
        }
        bw.write(level + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
