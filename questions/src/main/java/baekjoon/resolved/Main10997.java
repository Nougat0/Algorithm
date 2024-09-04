package baekjoon.resolved;

import java.io.*;

public class Main10997 {
    public static final String star = "*";
    public static final String blank = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // x: 1-1, 2-5, 3-9, 4-13, n-(4*(n-1)+1)
        // y: 1-1, 2-7, 3-11, 4-15, n-(4*(n-1)+3) :: 1은 예외
        // 오른쪽 위 꼭지점에 도달할 때까지 회오리를 그리면 될 듯
        int maxX = 4*(n-1)+1;
        int maxY = n==1 ? 1 : 4*(n-1)+3;
        boolean[][] whirl = new boolean[maxY][maxX];
        //시작점: 1-(0,0), 2-(2,4), 3-(4,6), 4-(6,8), n-(maxX/2, maxY/2+1)
        //종료점: 1-(0,0), 2-(4,0,), 3-(8,0), 4-(12,0), n-(maxX-1, 0)

        int currentSize = 2; //point의 stack 과 연관

        Point point = new Point(n==1 ? 0 : maxX/2, n==1 ? 0 : maxY/2 + 1);
        while(n==1 ? point.currentX==0 && point.currentY==0 : !(point.currentY == 0 && point.currentX == maxX-1)) {
            try { //n=1일 때, 그리고 마지막 직선을 그릴 때의 오류 catch 및 while문 종료
                for (int i = 0; i < currentSize; i++) { //별 찍기
                    whirl[point.currentY][point.currentX] = true;
                    point.go();
                }
            } catch (ArrayIndexOutOfBoundsException e) { break; }
            //다음 움직임
            currentSize += point.turn();
        }
        //출력
        for(int i=0; i<maxY; i++) {
            for(int j=0; j<maxX; j++) {
                if(i==1 && j>0) continue; //공백만 찍다가 줄이 끝날 경우 예외처리
                bw.write(whirl[i][j] ? star : blank);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 현재의 위치 및 이동할 방향, 이동할 거리 등을 관리하는 클래스
     */
    public static class Point {
        // 위, 오른쪽, 아래, 왼쪽 순서
        static final int[] x = new int[] {0,1,0,-1};
        static final int[] y = new int[] {-1,0,1,0};
        private int direction = 0; //현재의 방향, x와 y 배열의 순서 사용
        private int currentX; //현재 x 좌표
        private  int currentY; //현재 y 좌표
        private int stack = 1; //동일한 길이 사용 횟수

        public Point(int currentX, int currentY) {
            this.currentX = currentX;
            this.currentY = currentY;
        }

        /**
         * 방향을 전환하면서, 같은 길이를 2번째 사용했을 때 늘어날 길이(2) 반환.
         * @return 이번 move에서 더할 값을 전달
         */
        public int turn() {
            direction++;
            if(direction > 3) direction = 0;
            stack++;
            if(stack > 2) {
                stack = 1;
                return 2;
            } else return 0;
        }

        /**
         * 현재 진행방향으로 전진
         */
        public void go() {
            currentX += x[direction];
            currentY += y[direction];
        }
    }
}
