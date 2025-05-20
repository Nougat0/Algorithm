package baekjoon.resolved;

import java.io.*;

public class Main2393 {
    /*
        https://www.acmicpc.net/problem/2393
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("  ___  ___  ___").append("\n")
            .append("  | |__| |__| |").append("\n")
            .append("  |           |").append("\n")
            .append("   \\_________/").append("\n")
            .append("    \\_______/").append("\n")
            .append("     |     |").append("\n")
            .append("     |     |").append("\n")
            .append("     |     |").append("\n")
            .append("     |     |").append("\n")
            .append("     |_____|").append("\n")
            .append("  __/       \\__").append("\n")
            .append(" /             \\").append("\n")
            .append("/_______________\\").append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
