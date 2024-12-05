package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int temp; //값 담기용 임시변수
        int steps = 0; //loop 횟수
        while(a != b) { //gcd 실행
            steps++;
            temp = Math.min(a,b);
            a = Math.abs(a-b);
            b = temp;
        }
        bw.write(steps + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
