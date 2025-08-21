package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2037 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2037
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        int length = line.length();

        int time = 0;
        int pastNum, num = -1, turn;
        for(int i=0; i<length; i++) {
            pastNum = num;
            char c = line.charAt(i);
            num = getNumber(c);
            turn = getTurn(c);
            if(num > 1 && pastNum == num) {
                time += (w + p*turn);
            } else {
                time += p*turn;
            }
        }
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getNumber(char c) {
        if(c == ' ') return 1;
        else if(c < 'S') return (c - 'A') / 3 + 2;
        else if(c == 'S') return 7;
        else if(c <= 'V') return 8;
        else return 9; //if(c <= 'Z')
    }

    public static int getTurn(char c) {
        if(c == ' ') return 1;
        else if(c < 'S') return (c - 'A') % 3 + 1;
        else if(c == 'S') return 4;
        else if(c <= 'V') return c - 'T' + 1;
        else return c - 'W' + 1; //if(c <= 'Z')
    }
}
