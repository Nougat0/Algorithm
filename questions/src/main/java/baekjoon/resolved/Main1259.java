package baekjoon.resolved;

import java.io.*;

public class Main1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        char[] num;
        while((num = br.readLine().toCharArray())[0] != '0') {
            boolean isPalindrome = true;
            int length = num.length;
            for(int i=0; i<length/2; i++)
                //배열의 앞과 뒤가 다를 경우 팰린드롬수 아님
                if(num[i] != num[length-1-i]) {
                    isPalindrome = false;
                    break;
                }
            sb.append(isPalindrome ? "yes" : "no").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
