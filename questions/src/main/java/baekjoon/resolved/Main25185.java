package baekjoon.resolved;

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
            String[] pick = new String[4];
            for(int p=0; p<4; p++) {
                String card = st.nextToken();
                pick[p] = card;
            }
            sb.append(':').append(useStreakFreeze(pick) ? ')' : '(').append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean useStreakFreeze(String[] pick) {
        Arrays.sort(pick);

        //2장씩 같다 (3번)
        if(pick[0].equals(pick[1]) && pick[2].equals(pick[3])) {
            return true;
        }

        //예외처리가 너무 많아져서 그냥 모든 경우 확인...
        //1번+2번: 4장 중 3장을 고르는 4가지 모든 경우 확인
        for (int i=0; i<4; i++) {
            List<String> threeCards = new ArrayList<>();
            for (int j=0; j<4; j++) {
                if (i != j) threeCards.add(pick[j]);
            }
            // 고른 3장이 조건을 만족하는지 확인
            if (checkThree(threeCards.get(0), threeCards.get(1), threeCards.get(2))) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkThree(String c1, String c2, String c3) {
        // 세 카드의 알파벳(m, p, s)이 모두 같은지 확인
        if (c1.charAt(1) == c2.charAt(1) && c2.charAt(1) == c3.charAt(1)) {
            int n1 = c1.charAt(0) - '0';
            int n2 = c2.charAt(0) - '0';
            int n3 = c3.charAt(0) - '0';

            //1번: 세 숫자가 연속되는 경우
            if (n1+1 == n2 && n2+1 == n3) return true;
            //2번: 세 숫자가 모두 같은 경우
            if (n1 == n2 && n2 == n3) return true;
        }
        return false;
    }
}
