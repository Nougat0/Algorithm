package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3009 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3009
        https://www.acmicpc.net/source/79255629
        2024.06.05
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        /**
         * 3개 점 받기
         */
        for(int i=0; i<3; i++) {
            String[] token = br.readLine().split(" ");
            x.add(Integer.parseInt(token[0]));
            y.add(Integer.parseInt(token[1]));
        }
        /**
         * x, y 값 중에서 중복값이 없는 것 출력
         * 점이 3개밖에 없다는 점에서 과한 로직 같다...
         */
        for(int i: x) {
            if(Collections.frequency(x, i) == 1) {
                bw.write(String.format("%d ", i));
            }
        }
        for(int i: y) {
            if(Collections.frequency(y, i) == 1) {
                bw.write(String.format("%d%n", i));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
