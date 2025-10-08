package baekjoon.processing;

import java.io.*;

public class Main5362 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5362
    */
    public static String pattern = "iiing";
    public static String origin = "th";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            int length = line.length();
            for(int i=0; i<length; i++) {
                char c = line.charAt(i);
                if(i < length - 5 && c == 'i' && isPattern(line, i)) {
                    sb.append(origin);
                    i += 4;
                } else {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPattern(String line, int index) {
        for(int i=0; i<5; i++) {
            if(line.charAt(index+i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
