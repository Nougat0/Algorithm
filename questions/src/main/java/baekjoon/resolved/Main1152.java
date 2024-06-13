package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //공백으로 시작하거나 끝나는 경우 대비 trim
        String[] line = br.readLine().trim().split(" ");
        if(line[0].length() == 0) { //공백 1칸일 경우 예외처리
            System.out.println(0);
        } else {
            System.out.println(line.length);
        }
        br.close();
    }

    //다른분 보니까 StringTokenizer로 되게 간단하게 구현하심 2897robo
}
