package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11321 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11321
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        while(true) {
            line = br.readLine();
            if(line.length() == 1 && line.charAt(0) == '0') break;

            st = new StringTokenizer(line, "+");
            int[] count = new int[10];
            Stack<Integer>[] list = new Stack[10];

            while(st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                int index = number % 10;
                if(list[index] == null) list[index] = new Stack<>();

                list[index].add(number);
                count[index]++;
            }

            //담아놓은 것 짝지어 꺼내기
            for(int i=1; i<=4; i++) {
                if(count[i] == 0) continue;

                Stack<Integer> list1 = list[i];
                Stack<Integer> list2 = list[(10-i) % 10];
                while(count[i] > 0 && count[(10-i) % 10] > 0) {
                    sb.append(list1.pop()).append('+').append(list2.pop()).append('+');
                    count[i]--;
                    count[(10-i) % 10]--;
                }
            }

            //0, 5 꺼내기
            int[] doubles = new int[] {0, 5};
            for(int d : doubles) {
                if(count[d] / 2 == 0) continue;

                Stack<Integer> list3 = list[d];
                while(count[d] > 1) {
                    sb.append(list3.pop()).append('+').append(list3.pop()).append('+');
                    count[d] -= 2;
                }
            }

            //남은 항목 출력
            for(int i=0; i<=9; i++) {
                while(count[i] > 0) {
                    sb.append(list[i].pop()).append('+');
                    count[i]--;
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
