package baekjoon.resolved;

import java.io.*;

public class Main25594 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25594
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] HG = new String[]{
            "aespa", "baekjoon", "cau", "debug", "edge", "firefox",
            "golang", "haegang", "iu", "java", "kotlin", "lol",
            "mips", "null", "os", "python", "query",
            "roka", "solvedac", "tod", "unix", "virus",
            "whale", "xcode", "yahoo", "zebra"
        };
        char[][] words = new char[26][10];
        for(char c='a'; c<='z'; c++) {
            int alphabet = c-'a';
            String word = HG[alphabet];
            int length = word.length();
            for(int i=0; i<length; i++) {
                words[alphabet][i] = word.charAt(i);
            }
            words[alphabet][9] = (char) length;
        }

        String string = br.readLine();
        int length = string.length();
        int index = 0;
        boolean isHG = true;
        while(isHG && index < length) {
            int start = index;
            char[] word = words[string.charAt(index) - 'a'];
            while(index < length && word[index-start] == string.charAt(index)) {
                index++;
            }
            if(word[9] > index-start) {
                isHG = false;
            } else {
                sb.append(word[0]);
            }
        }

        if(isHG) {
            bw.write("It's HG!\n");
            bw.write(sb.toString());
        } else {
            bw.write("ERROR!");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
