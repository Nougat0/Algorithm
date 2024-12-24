package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String balanced = br.readLine();
        balanced = balanced.replace("()", "(1)");
        balanced = balanced.replace(")(", ")+(");
        bw.write(balanced);
        bw.flush();
        bw.close();
        br.close();
    }
}
