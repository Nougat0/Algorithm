package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3845 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3845
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int nx, ny, i;
        double[] x, y;
        double w;

        while(true) {
            st = new StringTokenizer(br.readLine());
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());
            w = Double.parseDouble(st.nextToken());

            if(nx == 0 && ny == 0 && w == 0.0) break;
            x = new double[nx];
            y = new double[ny];

            st = new StringTokenizer(br.readLine());
            for(i=0; i<nx; i++) {
                x[i] = Double.parseDouble(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(i=0; i<ny; i++) {
                y[i] = Double.parseDouble(st.nextToken());
            }

            Arrays.sort(x);
            Arrays.sort(y);

            //잔디깎기 진행
            boolean fullX = true, fullY = true;
            double s = 0, e = 0;
            if(x[0] - w/2 > 0 || x[nx-1] + w/2 < 75) fullX = false;
            if(y[0] - w/2 > 0 || y[ny-1] + w/2 < 100) fullY = false;
            for(i=0; i<nx && fullX; i++) {
                double start = Math.max(x[i] - w/2, 0);
                double end = x[i] + w/2;

                //스위핑 경우나누기
                if(start > e) {
                    s = start;
                    e = end;
                    fullX = false;
                } else if(start <= e && end > e) {
                    e = end;
                }
            }

            s = 0;
            e = 0;
            for(i=0; i<ny && fullY; i++) {
                double start = Math.max(y[i] - w/2, 0);
                double end = y[i] + w/2;

                //스위핑 경우나누기
                if(start > e) {
                    s = start;
                    e = end;
                    fullY = false;
                } else if(start <= e && end > e) {
                    e = end;
                }
            }

            if(fullX && fullY) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
