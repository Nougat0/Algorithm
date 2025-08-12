package baekjoon.resolved;

import java.io.*;

public class Main2630 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2630
    */
    public static int blue = 0;
    public static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력
        int length = Integer.parseInt(br.readLine());
        String line;
        boolean[][] paper = new boolean[length][length];
        for(int i=0; i<length; i++) {
            line = br.readLine();
            for(int j=0; j<length; j++) {
                paper[i][j] = (line.charAt(j*2) == '1');
            }
        }
        //재귀로 검사
        checkSquare(paper, 0, 0, length);
        System.out.println(white);
        System.out.println(blue);
        br.close();
    }

    /**
     * 정사각형 내부가 모두 같은 색인지 확인하는 함수
     * @param paper
     * @param startRow
     * @param startCol
     * @param length
     */
    public static void checkSquare(boolean[][] paper, int startRow, int startCol, int length) {
        //전면 통일여부 확인
        int blue = 0;
        int white = 0;
        checkUnity:
        for(int i=startRow; i<startRow+length; i++) {
            for(int j=startCol; j<startCol+length; j++) {
                if(paper[i][j]) blue++;
                else white++;
                if(blue > 0 && white > 0) break checkUnity;
            }
        }
        //통일여부에 따른 동작 분리
        if(blue > 0 && white > 0) { //통일되지 않으면 4개로 쪼개서 새로 확인
            int half = length/2;
            checkSquare(paper, startRow, startCol, half);
            checkSquare(paper, startRow+half, startCol, half);
            checkSquare(paper, startRow, startCol+half, half);
            checkSquare(paper, startRow+half, startCol+half, half);
        } else { //통일되었으면 갯수 추가
            addCount(blue > 0);
        }
    }

    /**
     * blue / white 갯수 추가
     * @param isBlue
     */
    public static void addCount(boolean isBlue) {
        if(isBlue) blue++;
        else white++;
    }
}
