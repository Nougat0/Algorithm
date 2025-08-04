package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main31287 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31287
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        boolean backToOrigin = false;
        int x=0, y=0, finishX, finishY; //원점, 종점
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            switch(c) {
                case 'U': y++; break;
                case 'D': y--; break;
                case 'L': x--; break;
                case 'R': x++; break;
            }
            if(x == 0 && y == 0) {
                backToOrigin = true;
                break;
            }
        }
        //1회차에서 원점 지나지 않을 경우 2회차 체크
        if(!backToOrigin && k > 1) {
            //종점 + 원점으로 각 점이 지나가는 직선 구하기
            finishX = x;
            finishY = y;
            // y = (slope)x + b
            // b = y - (slope)x
            double slope = (double) finishY / finishX;
            for(int i=0; i<n; i++) {
                char c = s.charAt(i);
                switch(c) {
                    case 'U': y++; break;
                    case 'D': y--; break;
                    case 'L': x--; break;
                    case 'R': x++; break;
                }
                //직선 위에 원점 있는지 확인
                if((i > 0 && i < n-1) && y == slope * x) {
                    backToOrigin = true;
                    break;
                }
            }
        }
        //출력
        bw.write(backToOrigin ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }
}
