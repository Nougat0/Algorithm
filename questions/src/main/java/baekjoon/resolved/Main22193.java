package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main22193 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/22193
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aLength = Integer.parseInt(st.nextToken());
        int bLength = Integer.parseInt(st.nextToken());
        String aString = br.readLine();
        String bString = br.readLine();
        BigInteger a = new BigInteger(aString);
        BigInteger b = new BigInteger(bString);

        bw.write(a.multiply(b).toString());
        bw.flush();
        bw.close();
        br.close();
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int aLength = Integer.parseInt(st.nextToken());
//        int bLength = Integer.parseInt(st.nextToken());
//        String aString = br.readLine();
//        String bString = br.readLine();
//        int a = Integer.parseInt(aString);
//        int b = Integer.parseInt(bString);
//        int[] result;
//
////        if(aLength <= 9 && bLength <= 9) sb.append(a * b);
////        else {
//            result = new int[50_000];
//            char[] n_arr = aString.toCharArray();
//            char[] m_arr = bString.toCharArray();
//            int maxLength = 0;
//            for(int i=aLength-1; i>=0; i--) {
//                int idx = 0;
//                for(int j=bLength-1; j>=0; j--, idx++) {
//                    int sum = result[idx] + (n_arr[i] - '0') + (m_arr[j] - '0');
//                    result[idx] = sum % 10;
//                    result[idx+1] = sum / 10;
//                }
//                maxLength = Math.max(maxLength, idx-1);
//            }
//            while(result[maxLength] > 0) {
//                maxLength++;
//            }
//            for(int i=1; i<maxLength; i++) {
//                sb.append(result[maxLength - i]);
////            }
//        }
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }
}
