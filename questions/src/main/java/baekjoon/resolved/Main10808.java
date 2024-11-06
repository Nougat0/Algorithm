package baekjoon.resolved;

import java.io.*;

public class Main10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력, 연산
        char[] word = br.readLine().toCharArray(); //97~122
        byte[] alphabet = new byte[26]; //최대 100개라서 byte 사용
        byte length = (byte) word.length;
        for(byte a=0; a<length; a++)
            alphabet[word[a]-97]++;
        //출력
        for(byte a=0; a<26; a++)
            sb.append(alphabet[a]).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
