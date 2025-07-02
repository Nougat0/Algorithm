package baekjoon.resolved;

import java.io.*;

public class Main9654 {
    /*
        https://www.acmicpc.net/problem/9654
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n")
            .append("N2 Bomber      Heavy Fighter  Limited    21        \n")
            .append("J-Type 327     Light Combat   Unlimited  1         \n")
            .append("NX Cruiser     Medium Fighter Limited    18        \n")
            .append("N1 Starfighter Medium Fighter Unlimited  25        \n")
            .append("Royal Cruiser  Light Combat   Limited    4         ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
