package baekjoon.resolved;

import java.io.*;

public class Main10989 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10989
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10_000_001];
        int max = 0;
        int min = 10_000_001;
        while(n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if(max < number) max = number;
            if(min > number) min = number;
            arr[number]++;
        }

        //출력
        for(int i=min; i<=max; i++) {
            if(arr[i] > 0) {
                int count = arr[i];
                while(count-- > 0) {
                    sb.append(i).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
