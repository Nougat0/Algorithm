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
        int x=0, y=0, finishX, finishY, symmX, symmY; //원점, 종점
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
        //1회차에서 원점 지나지 않을 경우 N회차 체크
        if(!backToOrigin && k > 1) {
            symmX = -x;
            symmY = -y;
            double distance = Math.sqrt(x*x + y*y);
            double dotDistance;
            x = 0;
            y = 0;
            //대칭점 위에 있는지 확인하기
            for(int i=0; i<n; i++) {
                char c = s.charAt(i);
                switch(c) {
                    case 'U': y++; break;
                    case 'D': y--; break;
                    case 'L': x--; break;
                    case 'R': x++; break;
                }
                //원점 기준 종점의 대칭점 N배수 값일 때, 0 <= N <= k 이면 도달 가능
                if(y * symmX == symmY * x) { //직선 위에 존재
                    dotDistance = Math.sqrt(x*x + y*y);
                    if(dotDistance % distance == 0 && dotDistance / distance <= k) { //K번째 대칭점 내에 존재
                        if(symmX / x > 0 && symmY / y > 0) { //방향 체크
                            backToOrigin = true;
                            break;
                        }
                    }
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
