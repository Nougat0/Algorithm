package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        while((input = br.readLine()) != null) {
            String[] line = input.trim().split("\\s+");
            int number = Integer.parseInt(line[0], Integer.parseInt(line[1]));
            String result = Integer.toString(number, Integer.parseInt(line[2]));
            if(result.length() > 7) {
                result = "ERROR";
            }
            sb.append(String.format("%7s", result).toUpperCase()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
