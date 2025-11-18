package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10353 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10353
    */
    public static int x;
    public static int y;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()); //세로
        y = Integer.parseInt(st.nextToken()); //가로
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int size = Integer.parseInt(br.readLine());
            if(checkFit(size)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkFit(int size) {
        //모서리를 어느 쪽에서 가져가는지 분기 처리
        if(x % size == 0 && (y-2) % size == 0) {
            //세로가 4개 다 가져감
            return true;
        } else if((x-2) % size == 0 && y % size == 0) {
            //세로가 0개 가져감
            return true;
        } else {
            //세로가 2개만 가져감
            if((y-1) % size == 0 && (x-1) % size == 0) {
                //위아래 엇갈려서 2개
                return true;
            } else if(y % size == 0 && (y-2) % size == 0 && (x-1) % size == 0) {
                //위아래 한쪽 방향으로 2개
                return true;
            } else if(x % size == 0 && (x-2) % size == 0 && (y-1) % size == 0) {
                //좌우 한쪽 방향으로 2개
                return true;
            }
        }
        return false;
    }
}
