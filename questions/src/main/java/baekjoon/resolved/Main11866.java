package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11866 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11866
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = i+1;
        }

        sb.append('<').append(a[k-1]);
        a[k-1] = 0;
        // 지금 index 부터 시작해서 3번째 다음 항목 가져오기
        // 3번째 다음을 찾을 때 0인 항목은 없어진 것이므로 세지 않고 건너뜀
        for(int i=1, idx=k-1; i<n; i++) {
            int count = 0;
            while(count < k) {
                idx = getNextIdx(idx, n);
                while(a[idx] == 0) { //다음 0이 아닌 idx 찾기
                    idx = getNextIdx(idx, n);
                }
                count++;
            }
            sb.append(", ").append(a[idx]);
            a[idx] = 0;
        }
        sb.append('>');
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getNextIdx(int idx, int length) {
        idx++; //다음 항목
        if(idx > length-1) idx -= length; //예외 처리
        return idx;
    }
}
