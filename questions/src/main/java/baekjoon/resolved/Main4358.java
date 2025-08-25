package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4358 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4358
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> species = new HashMap<>(); //(종 이름, 등장횟수)
        String tree;
        double sum = 0;
        while((tree = br.readLine()) != null) {
            species.compute(tree, (k, v) -> (v == null) ? 1 : v+1);
            sum++;
        }
        Map<String, Integer> sorted = new TreeMap<>(species);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f%n", entry.getValue() / sum * 100));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
