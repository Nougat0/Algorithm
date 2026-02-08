package baekjoon.resolved;

import java.io.*;

public class Main15181 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15181
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String notes;
        while((notes = br.readLine()).charAt(0) != '#') {
            int length = notes.length();
            int prev = notes.charAt(0);
            int now;
            int diff;
            boolean beautiful = true;
            for(int i=1; i<length; i++) {
                now = notes.charAt(i);
                diff = getDiff(prev, now);
                if(!(diff == 2 || diff == 4 || diff == 6)) {
                    beautiful = false;
                    break;
                }
                prev = now;
            }
            sb.append(beautiful ? "That music is beautiful.\n" : "Ouch! That hurts my ears.\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getDiff(int prev, int now) {
        prev -= 'A';
        now -= 'A';
        if(prev >= now) now += 7;
        return now - prev;
    }
}
