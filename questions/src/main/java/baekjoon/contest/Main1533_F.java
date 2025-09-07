package baekjoon.contest;

import java.io.*;
import java.util.*;

public class Main1533_F {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1533/6
    */
    public static final String WellKnown = "WellKnown";
    public static final String AdHoc = "AdHoc";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        //먼저 출제된 문제들 중 이번 문제에서 사용하는 알고리즘을 모두 사용하는 것이 있다면
        //이번 문제는 WellKnown 이 된다
        Set<String> cases = new HashSet<>();
        boolean z = false;
        boolean[][] S = new boolean[N+1][K+1];
        int[] usages = new int[21]; //알고리즘 사용된 것들의 index 기록해두기
        for(int i=1; i<=N; i++) {
            int usageIndex = 0;
            String line = br.readLine();
            StringBuilder builder = new StringBuilder();
            int count = 0;
            for(int j=1; j<=K; j++) {
                int index = z ? K-j+1 : j;
                boolean ij = line.charAt(index-1) == '1';
                builder.append((S[i][j] = ij) ? 1 : 0);
                if(ij) {
                    usages[++usageIndex] = j;
                    count++;
                }
            }
            //이전 문제들에서 이번 문제의 wellKnown 여부(z) 확인
            z = true;
            for(String s : cases) {
                int containsCount = 0;
                for(int j=1; j<=usageIndex; j++) {
                    if(S[i][usages[j]] == true && s.charAt(usages[j]-1) == '1') containsCount++;
                    else break;
                }
                if(containsCount == count) {
                    z = false;
                    break;
                }
            }
            if(i > 1 && !z) sb.append(WellKnown).append("\n");
            else sb.append(AdHoc).append("\n");
            cases.add(builder.toString());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
