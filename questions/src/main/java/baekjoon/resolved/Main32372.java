package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32372 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32372
    */
    public static int minX, maxX, minY, maxY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x, y, k;
        minX=-1; maxX=n+1; minY=-1; maxY=n+1;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            switch(k) {
                case 1: setMinMaxEquals(x, y, -1, 0); break;
                case 2: setMinMaxEquals(x, y, -1, 1); break;
                case 3: setMinMaxEquals(x, y, 0, 1); break;
                case 4: setMinMaxEquals(x, y, 1, 1); break;
                case 5: setMinMaxEquals(x, y, 1, 0); break;
                case 6: setMinMaxEquals(x, y, 1, -1); break;
                case 7: setMinMaxEquals(x, y, 0, -1); break;
                case 8: setMinMaxEquals(x, y, -1, -1); break;
            }
        }
        sb.append(minX == -1 ? maxX : minX).append(' ').append(minY == -1 ? maxY : minY);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void setMinMaxEquals(int x, int y, int xEquals, int yEquals) {
        if(minX != maxX)
            switch(xEquals) {
                case 1: minX = Math.max(x+1, minX); break;
                case -1: maxX = Math.min(x-1, maxX); break;
                default: minX = x; maxX = x; break;
            }
        if(minY != maxY)
            switch(yEquals) {
                case 1: minY = Math.max(y+1, minY); break;
                case -1: maxY = Math.min(y-1, maxY); break;
                default: minY = y; maxY = y; break;
            }
    }
}
