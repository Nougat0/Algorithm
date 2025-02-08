package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main10156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int asset = Integer.parseInt(st.nextToken());
        //과자 사먹기 위해 받아야 하는 금액
        int loan = price*cnt - asset;
        if(loan > 0) {
            bw.write(loan + "\n");
        } else {
            bw.write(0 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
