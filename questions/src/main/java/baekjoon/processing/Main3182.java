package baekjoon.processing;

import java.io.*;

public class Main3182 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3182
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n+1]; //선배 n명
        for(int i=1; i<=n; i++) ans[i] = Integer.parseInt(br.readLine());

        //모든 선배 대답 확인
        int max = 0, number = -1;
        for(int no=1; no<=n; no++) {
            int a = ans[no];
            int count = 0;
            boolean[] asked = new boolean[n+1];
            while((a = ans[a]) != no && !asked[a]) {
                asked[a] = true;
                count++;
            }
            if(count > max) {
                max = count;
                number = no;
            }
        }
        bw.write(number + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
