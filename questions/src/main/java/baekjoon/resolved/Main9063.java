package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9063 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9063
        https://www.acmicpc.net/source/79332190
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        /**
         * n개 점 받기
         */
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] token = br.readLine().split(" ");
            x.add(Integer.parseInt(token[0]));
            y.add(Integer.parseInt(token[1]));
        }
        /**
         * x, y 최소값,최대값 계산 후 차이를 한 변으로 간주
         */
        int xMax = Collections.max(x);
        int yMax = Collections.max(y);
        int xMin = Collections.min(x);
        int yMin = Collections.min(y);
        long area = 1L * (xMax-xMin) * (yMax-yMin);

        bw.write(area + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
