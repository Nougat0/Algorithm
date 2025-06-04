package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main8949 {
    /*
        https://www.acmicpc.net/problem/8949
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a, b;
        int aLength, bLength, maxLength;

        a = st.nextToken();
        aLength = a.length();

        b = st.nextToken();
        bLength = b.length();

        maxLength = Math.max(aLength, bLength);
        int aIndex, bIndex;
        for(int i=0, sum=0; i<maxLength; i++, sum=0) {
            aIndex = aLength - maxLength + i;
            bIndex = bLength - maxLength + i;
            if(aIndex >= 0) sum += Character.getNumericValue(a.charAt(aIndex));
            if(bIndex >= 0) sum += Character.getNumericValue(b.charAt(bIndex));
            sb.append(sum);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
