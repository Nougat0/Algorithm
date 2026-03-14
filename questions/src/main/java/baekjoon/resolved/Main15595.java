package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15595 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5544
    */
    private static final String ADMIN = "megalusion";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double solved = 0;
        double wrong = 0;
        Map<String, Integer> user = new HashMap<>();
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[1];
            boolean isAdmin = name.equals(ADMIN);
            boolean isSolved = Integer.parseInt(input[2]) == 4;
            
            int wrongTimes = user.getOrDefault(name, 0);
            
            if(isAdmin || wrongTimes == -1) continue;
            
            if(isSolved) {
                wrong += wrongTimes;
                solved++;
                user.put(name, -1); //이미 맞은 사람 표시
            } else {
                user.put(name, wrongTimes + 1);
            }
        }

        if(solved == 0) System.out.println(0);
        else System.out.println(solved / (solved + wrong) * 100);

        br.close();
    }
}
