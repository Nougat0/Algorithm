package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1431 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1431
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (s1, s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();
            int compareLength = Integer.compare(l1, l2);
            if(compareLength == 0) {
                int compareSum = Integer.compare(getSum(s1), getSum(s2));
                if(compareSum == 0) {
                    return compareLexicographic(s1, s2);
                } else {
                    return compareSum;
                }
            } else {
                return compareLength;
            }
        });
        for(int i=0; i<n; i++) {
            sb.append(list.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getSum(String line) {
        int length = line.length();
        int sum = 0;
        for(int i=0; i<length; i++) {
            char c = line.charAt(i);
            if(Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static int compareLexicographic(String s1, String s2) {
        int length = s1.length();
        for(int i=0; i<length; i++) {
            int compare = Character.compare(s1.charAt(i), s2.charAt(i));
            if(compare != 0) return compare;
        }
        return 0;
    }
}
