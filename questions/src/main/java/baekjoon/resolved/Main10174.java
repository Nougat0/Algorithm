package baekjoon.resolved;

import java.io.*;

public class Main10174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            char[] line = br.readLine().toCharArray();
            int length = line.length;
            boolean isPalindrome = true;
            for(int i=0; i<length/2; i++) {
                char former = line[i];
                char latter = line[length-1-i];
                if(former >= 97) former -= 97;
                else if(former >= 65) former -= 65;
                if(latter >= 97) latter -= 97;
                else if(latter >= 65) latter -= 65;

                if(former != latter) {
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome) sb.append("Yes");
            else sb.append("No");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
