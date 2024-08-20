package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine())) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}