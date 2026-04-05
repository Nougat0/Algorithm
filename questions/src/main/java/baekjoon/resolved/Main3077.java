package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3077 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3077
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> correct = new HashMap<>();
        String[] ans = new String[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            correct.put(st.nextToken(), i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            ans[i] = st.nextToken();
        }

        int sum = 0;
        int dom = n*(n-1)/2;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(correct.get(ans[i]) < correct.get(ans[j])) sum++;
            }
        }
        sb.append(sum).append('/').append(dom);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
