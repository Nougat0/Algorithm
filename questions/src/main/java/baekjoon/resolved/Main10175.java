package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10175 {
    /*
        https://www.acmicpc.net/problem/10175
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[4];
        char[] line;
        int index;
        while(n-- > 0) {
            //입력
            st = new StringTokenizer(br.readLine());
            String location = st.nextToken();
            line = st.nextToken().toCharArray();
            for(char c : line) {
                index = Species.valueOf(String.valueOf(c)).ordinal();
                count[index]++;
            }
            //최대값 찾기
            int value;
            int dominantValue = 0;
            int dominantSpecies = -1;
            boolean tie = false;
            for(index=0; index<4; index++) {
                value = (index + 1) * count[index];
                if(dominantValue < value) {
                    dominantValue = value;
                    dominantSpecies = index;
                    tie = false;
                } else if(dominantValue == value) {
                    tie = true;
                }
                count[index] = 0; //배열 초기화
            }
            //결과 출력
            sb.append(location).append(": ");
            if(tie) {
                sb.append("There is no");
            } else {
                sb.append("The ")
                    .append(Species.values()[dominantSpecies].getName())
                    .append(" is the");
            }
            sb.append(" dominant species\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public enum Species {
        C("Coyote"), B("Bobcat"), W("Wolf"), M("Mountain Lion");
        private String name;
        Species(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }
}
