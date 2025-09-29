package baekjoon.resolved;

import java.io.*;

public class Main2195 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2195
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        int lengthS = S.length();
        int lengthP = P.length();
        int pIndex = 0; // P index
        int count = 0;
        while(pIndex < lengthP) {
            //S(원본) 문자열의 처음부터 끝까지 훑으면서 대조
            //일치하는 구간 중 가장 긴 구간의 길이만큼 P index 갱신
            int maxLength = 0;
            int copyLength = 0;
            for(int i=0; i<lengthS && pIndex+copyLength<lengthP; i++) {
                if(S.charAt(i) == P.charAt(pIndex + copyLength)) {
                    copyLength++;
                } else if(copyLength > 0) {
                    maxLength = Math.max(maxLength, copyLength);
                    copyLength = 0;
                    //지금 불일치한 순간부터 시작일 수도 있다
                    if(S.charAt(i) == P.charAt(pIndex + copyLength)) {
                        copyLength++;
                    }
                }
            }
            if(copyLength > 0 && copyLength > maxLength) maxLength = copyLength;
            pIndex += maxLength;
            count++;
        }
        System.out.println(count);
        br.close();
    }
}
