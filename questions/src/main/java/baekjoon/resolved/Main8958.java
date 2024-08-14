package baekjoon.resolved;

import java.io.*;

public class Main8958 {
    public static final int initialScore = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            char[] testCase = br.readLine().toCharArray();
            int score = initialScore;
            int sum = 0;
            for(char c : testCase) //각 자리별 확인
                if(c == 'O') sum += score++; //O 마주하면 점수 더하고 ++
                else score = initialScore; //X 마주하면 최초 점수로 되돌림
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
