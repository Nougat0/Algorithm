package baekjoon.processing;

import java.io.*;

public class Main10996 {
    public static final String star = "*";
    public static final String blank = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // 1-1, 2-4, 3-6, 4-8
        int line = n==1 ? 1 : 2*n;
        for(int i=0; i<line; i++) {
            for(int j=0; j<n; j++)
                //짝수줄은 짝수(0,2,...)에 찍고
                //홀수줄은 홀수(1,3,...)에 찍기
                if(!(i%2==0 ^ j%2==0)) //xor(달라야 참) 의 반대(같아야 참)
                    bw.write(star);
                else if(!(n%2==0 ^ i%2!=0 && j==n-1)) //맨 끝 불필요한 blank는 찍지 않음
                    bw.write(blank);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
