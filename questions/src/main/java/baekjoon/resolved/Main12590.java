package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12590 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/12590
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        /*
            N번째 snapper까지 전력 들어옴 + 모두 ON일 최초의 경우
            = [arr[n] = arr[n-1]*2 + 1, arr[0]=0, 1<=n<=N] 의 규칙대로 전개하면 됨
            하지만 문제에서는 arr[n] < k 인 경우도 테스트케이스로 준다...

            따라서 이진법을 사용해서 풀어볼 수 있다 (0,1)
            k번째 snap 에서의 snapper 모습 확인해서 N 번째까지 모두 ON(1) 인지 확인
        */
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            sb.append("Case #").append(t).append(": ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //int[] r = new int[n+1];
            //for(int i=1; i<=n; i++) {
            //    r[i] = r[i-1]*2 + 1;
            //}
            //sb.append(r[n] == k ? "ON" : "OFF");

            String s = Integer.toBinaryString(k);
            int length = s.length();
            boolean isOn = length >= n;
            for(int snapper=0; isOn && snapper<n; snapper++) {
                //뒤에서부터 n개 점검
                if(s.charAt(length - 1 - snapper) == '0') {
                    isOn = false;
                }
            }
            sb.append(isOn ? "ON" : "OFF").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}