package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7602 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/7602
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n;
        int machine = 0;
        while((n = Integer.parseInt(br.readLine())) > 0) {
            machine++;
            int[] e = new int[n+1];
            for(int i=1; i<=n; i++) e[i] = Integer.parseInt(br.readLine());
            sb.append("Machine ").append(machine).append("\n");

            while(true) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int exercises = Integer.parseInt(st.nextToken());
                if(exercises == 0) break;

                long sum = 0;
                for(int i=0; i<exercises; i++) {
                    st = new StringTokenizer(br.readLine());
                    int lvl = Integer.parseInt(st.nextToken());
                    int min = Integer.parseInt(st.nextToken());
                    sum += e[lvl] * min;
                }
                sb.append(name).append(" ").append(sum).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
