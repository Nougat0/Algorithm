package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18022 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18022
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        int rhyme = new StringTokenizer(br.readLine()).countTokens();
        int n = Integer.parseInt(br.readLine());
        EenyMeeny selection = new EenyMeeny(rhyme, n);

        while(n-- > 0) {
            String name = br.readLine();
            selection.addKid(name);
        }

        sb = selection.process();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class EenyMeeny {
        private Queue<Integer> order;
        private String[] names;
        private int rhyme;
        private int n;
        private int kids;

        public EenyMeeny(int rhyme, int n) {
            this.order = new LinkedList<>();
            this.names = new String[n];
            this.rhyme = rhyme;
            this.n = n;


            this.kids = 0;
        }

        public void addKid(String name) {
            names[kids] = name;
            order.add(kids);
            kids++;
        }

        public StringBuilder process() {
            StringBuilder result = new StringBuilder();
            StringBuilder team1 = new StringBuilder();
            StringBuilder team2 = new StringBuilder();
            int team1Count = 0;
            int team2Count = 0;
            //Eeny Meeny 동작 진행
            for(int i=0; i<n; i++) {
                int index = select();
                if(i%2 == 0) {
                    team1.append(names[index]).append("\n");
                    team1Count++;
                } else {
                    team2.append(names[index]).append("\n");
                    team2Count++;
                }
            }
            //결과 반환
            result.append(team1Count).append("\n").append(team1);
            result.append(team2Count).append("\n").append(team2);
            return result;
        }

        private int select() {
            if(order.size() > 1) {
                for(int i=0; i<rhyme-1; i++) {
                    int thisTurn = order.poll();
                    order.add(thisTurn);
                }
            }
            return order.poll();
        }
    }
}
