package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3022 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3022
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LunchTable lunchTable = new LunchTable();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            lunchTable.getFood(br.readLine());
        }
        System.out.println(lunchTable.getWarned());
        br.close();
    }

    public static class LunchTable {
        private Map<String, Integer> children;
        private int total;
        private int warned;

        public LunchTable() {
            children = new HashMap<>();
            total = 0;
            warned = 0;
        }

        public void getFood(String name) {
            int alreadyTaken = children.getOrDefault(name, 0);
            if((total - alreadyTaken) < alreadyTaken) warned++;

            if(alreadyTaken == 0) children.put(name, 1);
            else children.put(name, alreadyTaken + 1);
            total++;
        }

        public int getWarned() {
            return this.warned;
        }
    }
}
