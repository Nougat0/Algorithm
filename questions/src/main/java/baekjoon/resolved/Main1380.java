package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1380 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1380
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Set<Integer> list;
        String[] names;
        int n, num, scenario = 0;

        while((n = Integer.parseInt(br.readLine())) != 0) {
            scenario++;
            names = new String[n];
            list = new HashSet<>();
            for(int i=0; i<n; i++) {
                names[i] = br.readLine();
            }
            //그냥 A, B와 상관없이 번호가 2번 등장하면 돌려받은 거 아닌가????
            for(int i=0; i<2*n-1; i++) {
                st = new StringTokenizer(br.readLine());
                num = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                if(list.contains(num)) {
                    //귀걸이 돌려줌
                    list.remove(num);
                } else {
                    //귀걸이 압수
                    list.add(num);
                }
            }
            for (Integer s : list) {
                num = s - 1;
                sb.append(scenario).append(' ').append(names[num]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
