package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main5338 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5338
    */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("       _.-;;-._\n")
            .append("'-..-'|   ||   |\n")
            .append("'-..-'|_.-;;-._|\n")
            .append("'-..-'|   ||   |\n")
            .append("'-..-'|_.-''-._|");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
