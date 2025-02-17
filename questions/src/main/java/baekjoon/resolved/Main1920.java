package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashSet<Integer> nSet = new HashSet<>();
        //기준대상 숫자들 목록
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nSet.add(Integer.parseInt(st.nextToken()));
        }
        //비교대상 숫자들 목록 - 존재여부 확인
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            boolean inList = nSet.contains(Integer.parseInt(st.nextToken()));
            sb.append(inList ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
