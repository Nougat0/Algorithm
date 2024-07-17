package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        /*
        EX) 246 * 87
        = 2*8 + 2*7 + 4*8 + 4*7 + 6*8 + 6*7
        = 2(8+7) + 4(8+7) + 6(8+7)
        = (2+4+6) * (8+7)
        */
        long sumA = 0, sumB = 0; //곱의 최대값이 약 81억이므로 long
        for(int i=0; i<a.length(); i++)
            sumA += Character.getNumericValue(a.charAt(i));
        for(int i=0; i<b.length(); i++)
            sumB += Character.getNumericValue(b.charAt(i));

        bw.write(sumA * sumB + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
