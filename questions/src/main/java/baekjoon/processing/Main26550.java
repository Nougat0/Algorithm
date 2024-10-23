package baekjoon.processing;

import java.io.*;

public class Main26550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            int layers = Integer.parseInt(br.readLine());
            int ornaments = 0;
            //레이어별 ornament 더하기
            for(int layer=1; layer<=layers; layer++) {
                //각 레이어의 ornament 구하기
                for(int o=1; o<=layer; o++) ornaments += o;
            }
            bw.write(ornaments + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
