package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tones = new int[8];
        boolean direction = false; //true: 오름차순, false: 내림차순
        boolean mixed = false;
        for(int i=0; i<8; i++) {
            tones[i] = Integer.parseInt(st.nextToken());
            if(i==1) {
                direction = tones[0] < tones[1];
            } else if(i>1) {
                mixed = direction != tones[i-1] < tones[i];
                if(mixed) break;
            }
        }
        bw.write(mixed ? "mixed" : direction ? "ascending" : "descending");
        bw.flush();
        bw.close();
        br.close();
    }
}
