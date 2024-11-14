package baekjoon.processing;

import java.io.*;

public class Main30156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        byte n = Byte.parseByte(br.readLine());
        byte[][] colors = new byte[n][2]; // {a:amber, b:brass}
        for(byte b=0; b<n; b++) {
            char[] balloons = br.readLine().toCharArray();
            for(char balloon : balloons) colors[b][balloon - 97]++;
            sb.append(Math.min(colors[b][0], colors[b][1])).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
