package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9575 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9575
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            Set<Integer> sum = new HashSet<>();

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(br.readLine());
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) b[i] = Integer.parseInt(st.nextToken());

            int k = Integer.parseInt(br.readLine());
            int[] c = new int[k];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<k; i++) c[i] = Integer.parseInt(st.nextToken());

            for(int i=0; i<n; i++) {
                int one = a[i];
                for(int j=0; j<m; j++) {
                    int two = b[j];
                    for(int l=0; l<k; l++) {
                        int three = c[l];
                        int number = one + two + three;
                        if(checkLucky(number)) {
                            sum.add(number);
                        }
                    }
                }
            }
            sb.append(sum.size()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkLucky(Integer number) {
        while(number/10 > 0) {
            if(number%10 != 5 && number%10 != 8) return false;
            number /= 10;
        }
        if(number%10 != 5 && number%10 != 8) return false;
        return true;
    }
}
