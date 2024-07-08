package baekjoon.resolved;

import java.io.*;
import java5.util.*;

public class Main1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());
        //구현
        Point kingPoint = new Point(king[0], Character.getNumericValue(king[1]));
        Point stonePoint = new Point(stone[0], Character.getNumericValue(stone[1]));

        for(int i=0; i<n; i++) {
            Move move = Enum.valueOf(Move.class, br.readLine());
            //IndexOutOfBounds 대신 값 미리 구해서 체크하기
            int newKingX = kingPoint.getX() + move.horizontal;
            int newKingY = kingPoint.getY() + move.vertical;
            int newStoneX = stonePoint.getX() + move.horizontal;
            int newStoneY = stonePoint.getY() + move.vertical;
            //King 진행해도 될지 체크
            if((newKingX <= 72 && newKingX >= 65) && (newKingY <= 8 && newKingY >= 1)) {
                if (newKingX == stonePoint.getX() && newKingY == stonePoint.getY()) { //King 이 Stone 위치로 이동
                    //Stone 진행해도 될지 체크
                    if((newStoneX <= 72 && newStoneX >= 65) && (newStoneY <= 8 && newStoneY >= 1)) {
                        stonePoint.setX(newStoneX);
                        stonePoint.setY(newStoneY);
                    } else {
                        continue;
                    }
                }
                kingPoint.setX(newKingX);
                kingPoint.setY(newKingY);
            }
        }
        //출력
        bw.write(String.format("%c%d%n%c%d%n",
                (char) kingPoint.getX(), kingPoint.getY(),
                (char) stonePoint.getX(), stonePoint.getY()
        ));
        bw.flush();
        bw.close();
        br.close();

    }
    /* 좌표 체크용 클래스 */
    public static class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
        public int getY() { return y; }
        public void setY(int y) { this.y = y; }
    }
    /* 움직임 관련 Enum */
    public enum Move {
        R(1,0),
        L(-1,0),
        B(0,-1),
        T(0,1),
        RT(1,1),
        LT(-1,1),
        RB(1,-1),
        LB(-1,-1);

        int horizontal;
        int vertical;

        Move(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }
}
