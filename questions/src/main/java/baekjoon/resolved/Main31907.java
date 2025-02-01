package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main31907 {
    public static final int COL = 4; //열
    public static final int ROW = 3; //행
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int multiply = Integer.parseInt(br.readLine()); //배수
        Letter g = new Letter('G', multiply, 1,1);
        Letter i = new Letter('I', multiply, 2,2);
        Letter s = new Letter('S', multiply, 3,3);
        Letter t = new Letter('T', multiply, 2,4);
        //출력
        for(int r=1; r<=ROW*multiply; r++) {
            for(int c=1; c<=COL*multiply; c++) {
                if(g.inRange(r,c)) {
                    sb.append(g.letter);
                } else if(i.inRange(r,c)) {
                    sb.append(i.letter);
                } else if(s.inRange(r,c)) {
                    sb.append(s.letter);
                } else if(t.inRange(r,c)) {
                    sb.append(t.letter);
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Letter {
        char letter; //출력할 문자
        //문자출력 열 범위
        int xStart;
        int xEnd;
        //문자출력 행 범위
        int yStart;
        int yEnd;

        /**
         * 생성자
         * @param letter 출력할 문자
         * @param multiply 배수
         * @param x 1배수일 때 열 좌표
         * @param y 1배수일 때 행 좌표
         */
        public Letter(char letter, int multiply, int x, int y) {
            this.letter = letter;
            this.xEnd = x*multiply;
            this.yEnd = y*multiply;
            this.xStart = xEnd - multiply + 1;
            this.yStart = yEnd - multiply + 1;
        }

        /**
         * 현재위치와 해당 Letter의 범위 비교 함수
         * @param x 현재 열 위치
         * @param y 현재 행 위치
         * @return 범위 내일 경우 true, 아닐 경우 false
         */
        boolean inRange(int x, int y) {
            if(x >= xStart && x <= xEnd && y >= yStart && y <= yEnd) {
                return true;
            }
            return false;
        }
    }
}
