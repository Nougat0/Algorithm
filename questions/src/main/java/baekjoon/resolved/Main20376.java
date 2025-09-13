package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main20376 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/20376
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> monuments = new HashSet<>();
        String line;
        while((line = br.readLine()) != null) {
            monuments.add(line.substring(11, line.length()));
        }
        System.out.println(monuments.size());
        br.close();
    }
}
