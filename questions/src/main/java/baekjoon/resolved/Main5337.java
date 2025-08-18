package baekjoon.resolved;

import java.io.*;

public class Main5337 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5337
    */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(".  .   .\n").append("|  | _ | _. _ ._ _  _\n").append("|/\\|(/.|(_.(_)[ | )(/.\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
