package baekjoon.resolved;

import java.io.*;

public class Main2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int count = 0;

        for(int i=1; i<=n; i++) {
            if(n % i == 0) count ++;
            if(count == k) {
                bw.write(String.format("%d%n", i));
                break;
            }
        }
        if(count < k) bw.write(String.format("%d%n", 0));

        bw.flush();
        bw.close();
        br.close();
    }
}
