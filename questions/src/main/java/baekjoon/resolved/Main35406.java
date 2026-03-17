package baekjoon.resolved;

import java.io.*;

public class Main35406 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35406
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ICPC icpc = new ICPC(br.readLine().toCharArray());
        System.out.println(icpc.getScore());
        br.close();
    }

    public static class ICPC {
        private char[] line;
        private int length;
        private char[] boooo;
        private char[] bravo;

        public ICPC(char[] line) {
            this.line = line;
            this.length = line.length;
            this.boooo = "boooo".toCharArray();
            this.bravo = "bravo".toCharArray();
        }

        public int getScore() {
            int i=0;
            int score = 0;
            while(i < this.length) {
                char c = line[i];
                switch(c) {
                    case 'h':
                        if(i+1 < length && line[i+1] == 'a') {
                            score++;
                            i++;
                        }
                        break;
                    case 'b':
                        if(i+4 < length) {
                            if(isBoooo(i)) {
                                score--;
                                i += 4;
                            } else if(isBravo(i)) {
                                score += 3;
                                i += 4;
                            }
                        }
                        break;
                }
                i++;
            }
            return score;
        }

        private boolean isBoooo(int i) {
            for(int j=1; j<=4; j++) {
                if(boooo[j] != line[i+j]) return false;
            }
            return true;
        }

        private boolean isBravo(int i) {
            for(int j=1; j<=4; j++) {
                if(bravo[j] != line[i+j]) return false;
            }
            return true;
        }
    }
}
