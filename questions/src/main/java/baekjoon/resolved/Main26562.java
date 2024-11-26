package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main26562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int wallets = Integer.parseInt(br.readLine());
        for(int w=0; w<wallets; w++) {
            st = new StringTokenizer(br.readLine());
            int value = 0;
            while(st.hasMoreTokens())
                value += getValue(st.nextToken().charAt(0));
            sb.append("$").append(value).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 각 대통령 이름으로 지폐가치 반환
     * @param firstLetter
     * @return
     */
    private static int getValue(char firstLetter) {
        switch(firstLetter) {
            case 'F': return 100;
            case 'G': return 50;
            case 'J': return 20;
            case 'H': return 10;
            case 'L': return 5;
            case 'W': return 1;
            default: return 0;
        }
    }
}
