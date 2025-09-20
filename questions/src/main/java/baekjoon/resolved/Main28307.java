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
        int lines = 0;
        //윗줄 입력
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
            boolean colored = st.nextToken().equals("1");
            tri[UP][j] = colored;
            if(colored) colorCount++;
        }
        //아랫줄 입력 + 체크
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
            boolean coloredUp = tri[UP][j];
            boolean coloredDown = st.nextToken().equals("1");
            tri[DOWN][j] = coloredDown;
            //인접 체크해서 변 제거
            if(coloredUp) {
                //윗줄 좌우 인접한지 확인
                if(j-1 >= 0 && tri[UP][j-1]) lines -= 2;
                //(홀수일 경우) 아래와 인접한지 확인
                if(j % 2 == 0 && coloredDown) lines -= 2;
            }
            if(coloredDown) {
                //아랫줄 좌우 인접한지 확인
                if(j-1 >= 0 && tri[DOWN][j-1]) lines -= 2;
                colorCount++; //갯수 추가
            }
        }
        System.out.println(lines + colorCount*3);
        br.close();
    }
}
