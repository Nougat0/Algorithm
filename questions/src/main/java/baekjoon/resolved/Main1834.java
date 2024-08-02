package baekjoon.resolved;

import java.io.*;

public class Main1834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long sum = 0l;

        //n*i의 값이 long이 되어야 하므로 i를 long으로 미리 지정
        for(long i=1; i<n; i++) sum += n*i + i;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
