package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4500 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4500
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] names = new String[21];
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            int index = 1;
            int length;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                names[index++] = st.nextToken();
            }
            length = index-1;
            String startName = br.readLine();
            int n = Integer.parseInt(br.readLine());
            //시작할 사람의 위치 탐색
            for(int i=1; i<=length; i++) {
                if(startName.equals(names[i])) index = i;
            }
            //우승자 확인
            index += (n - 1);
            index %= length;
            if(index == 0) index = length;
            sb.append(names[index]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
