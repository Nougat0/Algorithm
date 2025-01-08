package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main14491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int decimal = Integer.parseInt(br.readLine());
        String nonary = Integer.toString(decimal, 9);
        bw.write(nonary);
        bw.flush();
        bw.close();
        br.close();
    }
}
