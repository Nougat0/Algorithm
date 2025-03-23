package baekjoon.resolved;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        bw.write(a.add(b).toString());
        /*
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        int maxLength = Math.max(a.length, b.length);
        int[] result = new int[maxLength + 1]; //한 자리 더 올라갈 가능성
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int calcResult;
        int aNum, bNum;
        for(int i=maxLength; i>=0; i--) {
            aNum = aIndex >= 0 ? (a[aIndex--] - '0') : 0;
            bNum = bIndex >= 0 ? (b[bIndex--] - '0') : 0;
            calcResult = aNum + bNum;
            result[i] = calcResult % 10;
            result[i-1] = calcResult / 10;
        }
        if(result[0] > 0) sb.append(result[0]);
        for(int i=1; i<=maxLength; i++) {
            sb.append(result[i]);
        }
        bw.write(sb.toString());*/
        bw.flush();
        bw.close();
        br.close();
    }
}
