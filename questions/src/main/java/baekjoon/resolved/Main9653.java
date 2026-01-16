package baekjoon.resolved;

import java.io.*;

public class Main9653 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9653
    */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("    8888888888  888    88888\n");
        sb.append("   88     88   88 88   88  88\n");
        sb.append("    8888  88  88   88  88888\n");
        sb.append("       88 88 888888888 88   88\n");
        sb.append("88888888  88 88     88 88    888888\n\n");

        sb.append("88  88  88   888    88888    888888\n");
        sb.append("88  88  88  88 88   88  88  88\n");
        sb.append("88 8888 88 88   88  88888    8888\n");
        sb.append(" 888  888 888888888 88  88      88\n");
        sb.append("  88  88  88     88 88   88888888");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
