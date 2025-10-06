package baekjoon.processing;

import java.io.*;

public class Main2448 {
    /*
        N은 항상 3*2^k (0 <= k <= 10)
        24 입력 시 다음 삼각형이 나타나야 함 => 높이인듯

        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2448
    */
    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        int n = N / 3;
        boolean[][] triangle = new boolean[n][n];

        punchHoles(triangle, 0, 0, n);

        StringBuilder top = getPattern(star, blank.repeat(5));
        StringBuilder mid = getPattern(star, blank, star, blank, blank, blank);
        StringBuilder btm = getPattern(star.repeat(5), blank);
        StringBuilder empty = getPattern(blank.repeat(6));

        StringBuilder lastTop = getPattern(star);
        StringBuilder lastMid = getPattern(star, blank, star);
        StringBuilder lastBtm = getPattern(star.repeat(5));

        for(int i=0; i<N; i++) {
            int y = i/3;
            int row = i%3;
            sb.append(blank.repeat(N-i-1));
            for(int x=0; x<=y; x++) {
                if(triangle[y][x]) {
                    sb.append(empty);
                } else if(x == y) {
                    switch(row) {
                        case 0: sb.append(lastTop); break;
                        case 1: sb.append(lastMid); break;
                        default: sb.append(lastBtm);
                    }
                } else {
                    switch(row) {
                        case 0: sb.append(top); break;
                        case 1: sb.append(mid); break;
                        default: sb.append(btm);
                    }
                }
            }
            sb.append(newLine);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 4등분해서 우측상단 칸 구멍 뚫기
     * @param arr true:구멍, false: 별
     * @param yStart 사각형 좌측 상단 y값
     * @param xStart 사각형 좌측 상단 x값
     * @param length 이번 사각형 길이
     */
    public static void punchHoles(boolean[][] arr, int yStart, int xStart, int length) {
        if(length < 2) return;

        int newLength = length/2;
        for(int y=yStart; y<yStart+newLength; y++) {
            for(int x=xStart+newLength; x<xStart+length; x++) {
                arr[y][x] = true;
            }
        }

        punchHoles(arr, yStart, xStart, newLength);
        punchHoles(arr, yStart+newLength, xStart, newLength);
        punchHoles(arr, yStart+newLength, xStart+newLength, newLength);
    }

    /**
     * 전달받은 문자열(가변)을 이어붙인 StringBuilder 반환
     * @param args
     * @return
     */
    public static StringBuilder getPattern(String... args) {
        StringBuilder sb = new StringBuilder();
        for(String str : args) {
            sb.append(str);
        }
        return sb;
    }
}
