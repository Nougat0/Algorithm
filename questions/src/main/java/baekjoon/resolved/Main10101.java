package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10101 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10101
        https://www.acmicpc.net/source/79393473
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] angle = new int[3];

        /**
         * 3개 각 받기
         */
        for(int i=0; i<3; i++) {
            angle[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 삼각형 분류하기
         */
        if(angle[0] + angle[1] + angle[2] == 180) {
            if(angle[0] == angle[1] && angle[1] == angle[2])
                bw.write("Equilateral\n");
            else if(angle[0] == angle[1] || angle[0] == angle[2] || angle[1] == angle[2])
                bw.write("Isosceles\n");
            else
                bw.write("Scalene\n");
        } else {
            bw.write("Error\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
