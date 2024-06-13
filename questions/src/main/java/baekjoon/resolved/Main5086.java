package baekjoon.resolved;

import java.io.*;

public class Main5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean hasNext = true;

        while(hasNext) {
            String[] testCase = br.readLine().split(" ");
            int first = Integer.parseInt(testCase[0]);
            int second = Integer.parseInt(testCase[1]);

            if(first == 0) {
                hasNext = false;
            } else {
                if(second % first == 0)
                    bw.write(String.format("%s%n", "factor"));
                else if(first % second == 0)
                    bw.write(String.format("%s%n", "multiple"));
                else
                    bw.write(String.format("%s%n", "neither"));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
