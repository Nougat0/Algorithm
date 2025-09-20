package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28307 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/28307
    */
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int N = Integer.parseInt(br.readLine());
        boolean[][] tri = new boolean[2][N];
        int colorCount = 0;
        //입력
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                boolean colored = st.nextToken().equals("1");
                tri[i][j] = colored;
                if(colored) colorCount++;
            }
        }
        int lines = colorCount*3;
        //인접 체크해서 변 제거
        for(int j=0; j<N; j++) {
            boolean coloredUp = tri[UP][j];
            boolean coloredDown = tri[DOWN][j];
            if(coloredUp) {
                //윗줄 좌우 인접한지 확인
                if(j+1 < N && tri[UP][j+1]) lines -= 2;
                //(홀수일 경우) 아래와 인접한지 확인
                if(j % 2 == 0 && coloredDown) lines -= 2;
            }
            if(coloredDown) {
                //아랫줄 좌우 인접한지 확인
                if(j+1 < N && tri[DOWN][j+1]) lines -= 2;
            }
        }
        System.out.println(lines);
        br.close();
    }
}
