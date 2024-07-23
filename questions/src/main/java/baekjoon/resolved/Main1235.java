package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];
        for(int i=0; i<n; i++) numbers[i] = br.readLine();

        boolean notMatched = true;
        int length = 1;
        while(notMatched) {
            Set<String> modified = new HashSet<>();
            for(int i=0; i<n; i++) {
                modified.add(
                        numbers[i].substring(
                                numbers[i].length()-length
                        ));
            }
            if(modified.size() == n) {
                bw.write(length+"\n");
                notMatched = false;
            } else {
                length++;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
