package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4404 {
    /*
        https://www.acmicpc.net/problem/4404
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //Dog, Gopher 좌표 수집
        st = new StringTokenizer(br.readLine());
        double gX = Double.parseDouble(st.nextToken());
        double gY = Double.parseDouble(st.nextToken());
        double dX = Double.parseDouble(st.nextToken());
        double dY = Double.parseDouble(st.nextToken());

        boolean canEscape = false;
        double escapeX = 0;
        double escapeY = 0;

        String coord;
        while((coord = br.readLine()) != null) {
            st = new StringTokenizer(coord);
            double hX = Double.parseDouble(st.nextToken());
            double hY = Double.parseDouble(st.nextToken());
            //All distances are in metres, to the nearest mm.
            double gopherDistance = Math.round(Math.sqrt(Math.pow(gY - hY, 2) + Math.pow(gX - hX, 2)) * 1000) / 1000.0;
            double dogDistance = Math.round(Math.sqrt(Math.pow(dY - hY, 2) + Math.pow(dX - hX, 2)) * 1000) / 1000.0;

            //동시에 도착하면 도망/잡힘 둘 다 가능
            //여러 개가 가능하면 아무거나 선택하기
            if(gopherDistance * 2 <= dogDistance) {
                canEscape = true;
                escapeX = hX;
                escapeY = hY;
                break;
            }
        }
        //출력
        if(canEscape) {
            sb.append("The gopher can escape through the hole at (").append(String.format("%.3f", escapeX)).append(",").append(String.format("%.3f", escapeY)).append(").");
        } else {
            sb.append("The gopher cannot escape.");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
