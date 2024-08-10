package baekjoon.resolved;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] n = br.readLine().toCharArray();
        long sum = 0l;
        for(int i=n.length-1; i>=0; i--) {
            int num; //각 자리의 수 0~9, A~F

            if(n[i] >= 65) num = n[i]-65+10;
            else num = n[i] - 48;

            sum += num * (long) Math.pow(16, n.length-1-i);
        }
        //출력
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
