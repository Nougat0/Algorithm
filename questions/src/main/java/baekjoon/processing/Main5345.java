package baekjoon.processing;

import java.io.*;

public class Main5345 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5345
    */
    static final int P = 0;
    static final int L = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int between, length, count;
        char c;
        String line;
        boolean[] plu = new boolean[2];
        boolean isP, isL, isU;

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            line = br.readLine();
            between = 0;
            count = 0;
            length = line.length();
            for(int i=0; i<length; i++) {
                c = line.charAt(i);
                isP = c == 'p' || c == 'P';
                isL = c == 'l' || c == 'L';
                isU = c == 'u' || c == 'U';
                if(plu[P]) {
                    if(plu[L]) {
                        if(isU) {
                            if(between > 0) {
                                count++;
                            }
                            //조건 충족 여부와 상관 없이 초기화
                            plu[P] = false;
                            plu[L] = false;
                        } else {
                            between++;
                        }
                    } else if(isL){
                        plu[L] = true;
                    } else {
                        between++;
                    }
                } else if(isP) {
                    plu[P] = true;
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
