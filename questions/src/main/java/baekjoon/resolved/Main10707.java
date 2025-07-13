package baekjoon.resolved;

import java.io.*;

public class Main10707 {
    /*
        https://www.acmicpc.net/problem/10707
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int A = Integer.parseInt(br.readLine());
        final int B = Integer.parseInt(br.readLine());
        final int C = Integer.parseInt(br.readLine());
        final int D = Integer.parseInt(br.readLine());
        final int P = Integer.parseInt(br.readLine());

        long companyX = P * A;
        long companyY = B;

        //Y사 추가금 계산
        if(P > C) {
            companyY += (P-C) * D;
        }

        System.out.println(Math.min(companyX, companyY));
        br.close();
    }
}
