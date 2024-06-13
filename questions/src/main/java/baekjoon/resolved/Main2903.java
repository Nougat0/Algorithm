package baekjoon.resolved;

import java.io.*;

public class Main2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // row, number
        // 1, 1
        // 2, 7 (+6)
        // 3, 19 (+12)
        // 4, 37 (+18)
        // 5, 61 (+24)
        // n, 1 + 6*1 + 6*2 + ... + 6*(n-1)

        //몇 번째 row에 있는지 확인
        int i=1, number=1; //1 row는 임의로 넣음
        while(number < n) {
            i++;
            number += 6*(i-1);
        }
        //row 번호 출력
        bw.write(String.valueOf(i));
        bw.flush();

        bw.close();
        br.close();
    }
}
