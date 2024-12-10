package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main29863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sleep = Integer.parseInt(br.readLine());
        int awake = Integer.parseInt(br.readLine());
        if(sleep >= 20) sleep -= 24;
        bw.write(awake - sleep +"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
