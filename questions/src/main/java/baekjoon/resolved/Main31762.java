package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31762 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31762
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int R = Integer.parseInt(st.nextToken()); //row 수 (공통)
        // 어차피 스크롤하면 처음부터 끝까지 전부 이동해야 함... column 수 따질 것 없는 듯
        boolean appropriate = true;

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            String matrix = st.nextToken();
            String pattern = st.nextToken();
            if(matrix.contains("-") && pattern.contains("*")) {
                appropriate = false;
                break;
            }
        }
        System.out.println(appropriate ? "Y" : "N");
        br.close();
    }
}
