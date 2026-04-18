package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main25185 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25185
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            Day day = new Day();
            for(int p=0; p<4; p++) {
                String card = st.nextToken();
                day.putNumber(card);
            }
            sb.append(':').append(day.useStreakFreeze() ? ')' : '(').append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Day {
        private int[] pick;
        private int count;
        private int m;
        private int p;
        private int s;
        public Day() {
            this.pick = new int[4];
            this.count = 0;
            this.m = 0;
            this.p = 0;
            this.s = 0;
        }

        public void putNumber(String card) {
            if(count > 3) return;
            int num = card.charAt(0) - '0';
            char rowChar = card.charAt(1);
            int row = 0;
            switch(rowChar) {
                case 'm': m++; break;
                case 'p': p++; row++; break;
                case 's': s++; row += 2; break;
            }
            pick[count++] = num + row*9;
        }

        public boolean useStreakFreeze() {
            Arrays.sort(pick);
            if(m >= 3 || p >= 3 || s >= 3) {
                //3개 이상 같은 알파벳 존재
                //같거나 연속 숫자
                int sameRow = m >= 3 ? 0 : (p >= 3 ? 1 : 2);
                int startIndex = pick[0] / 9 == sameRow ? 0 : 1;
                boolean same = true;
                boolean upward = true;
                for(int i=startIndex; i<startIndex+2; i++) {
                    int diff = pick[i+1] - pick[i];
                    if(same && (diff != 0)) same = false;
                    if(upward && (diff != 1)) {
                        //만약 같은 숫자라서 틀린 거라면 한 번 더 기회 주기
                        if(diff == 0 && i+2 < 4 && pick[i+2] - pick[i+1] == 1) {
                            upward = true;
                            i++;
                        } else {
                            upward = false;
                        }
                    }
                }
                if(same || upward) return true;
            } else if(m != 1 && p != 1 && s != 1){
                if(pick[0] == pick[1] && pick[2] == pick[3]) return true;
            }
            return false;
        }
    }
}
