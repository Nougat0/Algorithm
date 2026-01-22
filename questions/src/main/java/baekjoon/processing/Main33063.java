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
         * 매 동작마다 x, y, z 한 줄씩 뚫린 개수 확인 (X)
         * 매 동작마다 x, y, z 앞뒤 2개씩 확인해서 개수 증감 확인 (O)
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
        boolean[][][] cheese;
        long total;
        public Cheese(int n) {
            int length = n+4;
            this.cheese = new boolean[length][length][length];
            this.total = 0;
        }

        public long poke(int x, int y, int z) {
            this.cheese[x+2][y+2][z+2] = true;
            long count = checkCount(x+2, y+2, z+2);
            return count;
        }

        private long checkCount(int x, int y, int z) {
            int xDiff = checkRow(cheese[x-2][y][z], cheese[x-1][y][z], cheese[x+1][y][z], cheese[x+2][y][z]);
            int yDiff = checkRow(cheese[x][y-2][z], cheese[x][y-1][z], cheese[x][y+1][z], cheese[x][y+2][z]);
            int zDiff = checkRow(cheese[x][y][z-2], cheese[x][y][z-1], cheese[x][y][z+1], cheese[x][y][z+2]);
            return (total += (xDiff + yDiff + zDiff));
        }

        private int checkRow(boolean ff, boolean f, boolean l, boolean ll) {
            // 같은 곳을 또 뚫지는 않음을 보장함 (문제에서)
            boolean former = ff && f;
            boolean latter = ll && l;
            boolean noSide = !ff && !ll;
            if(former && latter) { // 11X11 기존 2개였던 게 하나가 됨
                return -1;
            } else if(former ^ latter) { // 11X00 OR 00X11 OR 11X10 OR 11X01 OR 01X11 OR 10X11 기존에 합쳐짐
                return 0;
            } else if(noSide && (f || l)){ // 00X10 OR 01X00 OR 01X10 하나가 생김
                return 1;
            } else { // 10X01 이어지지 않음
                return 0;
            }
        }
    }
}
