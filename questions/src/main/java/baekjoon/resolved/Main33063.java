package baekjoon.resolved;

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
         * 매 동작마다 x, y, z 앞뒤 2개씩 확인해서 개수 증감 확인 (X)
         * 매 동작마다 x, y, z 한 줄씩 통째로 뚫린 개수 확인 (O)
         *
         * 문제를 완전히 잘못 해석하고 있었다... 1*1*N 의 N을 변수로 봐버렸음 어머...별꼴이다...
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
        int total;
        public Cheese(int n) {
            this.n = n;
            this.cheese = new boolean[n][n][n];
            this.xCount = new int[n][n];
            this.yCount = new int[n][n];
            this.zCount = new int[n][n];
            this.total = 0;
        }

        public int poke(int x, int y, int z) {
            if(++this.xCount[y][z] == n) total++;
            if(++this.yCount[x][z] == n) total++;
            if(++this.zCount[x][y] == n) total++;
            return total;
        }
    }
}
