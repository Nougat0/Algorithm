package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main33063 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33063
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int x, y, z;
        /**
         * 뚫린 공간을 확인하고, 각 방향(x, y, z)별로 2개 이상 이어진 곳 확인
         * 그냥 공간 뚫고, 2개 이상 이어져있는지만 확인하면 될 듯?
         * 아 근데 각 동작마다 출력해야 하네...최대 20만 회 반복, 빡센데...
         *
         * 매 동작마다 x, y, z 한 줄씩 뚫린 개수 확인
         * 이전 개수와 비교해서 등락 확인
         */
        Cheese cheese = new Cheese(n);
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            sb.append(cheese.poke(x, y, z)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Cheese {
        private int n;
        boolean[][][] cheese;
        int[][] xCount;
        int[][] yCount;
        int[][] zCount;
        boolean[] temp;
        int total;
        public Cheese(int n) {
            this.n = n;
            this.cheese = new boolean[n][n][n];
            this.xCount = new int[n][n];
            this.yCount = new int[n][n];
            this.zCount = new int[n][n];
            this.total = 0;
            this.temp = new boolean[n];
        }

        public int poke(int x, int y, int z) {
            this.cheese[x][y][z] = true;
            int count = checkCount(x, y, z);
            return count;
        }

        private int checkCount(int x, int y, int z) {
            int xDiff = checkRow(getXRow(y, z)) - this.xCount[y][z];
            int yDiff = checkRow(getYRow(x, z)) - this.yCount[x][z];
            int zDiff = checkRow(getZRow(x, y)) - this.zCount[x][y];
            if(xDiff != 0) this.xCount[y][z] = xDiff;
            if(yDiff != 0) this.yCount[x][z] = yDiff;
            if(zDiff != 0) this.zCount[x][y] = zDiff;
            return (total += (xDiff + yDiff + zDiff));
        }

        private boolean[] getXRow(int y, int z) {
            temp = new boolean[n];
            for(int i=0; i<n; i++) {
                temp[i] = cheese[i][y][z];
            }
            return temp;
        }

        private boolean[] getYRow(int x, int z) {
            temp = new boolean[n];
            for(int i=0; i<n; i++) {
                temp[i] = cheese[x][i][z];
            }
            return temp;
        }

        private boolean[] getZRow(int x, int y) {
            return cheese[x][y];
        }

        private int checkRow(boolean[] row) {
            int length = row.length;
            int count = 0;
            int open = 0;
            for(int i=0; i<length; i++) {
                if(row[i]) {
                    open++;
                } else {
                    if(open > 1) count++;
                    open = 0;
                }
            }
            if(open > 1) count++;
            return count;
        }
    }
}
