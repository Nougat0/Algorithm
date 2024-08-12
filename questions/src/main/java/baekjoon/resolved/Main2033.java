package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main2033 {
    /*
    if(n > 10) //반올림
        n = (n + 5)/10 * 10;
    if(n > 100) //반올림
        n = (n + 50)/100 * 100;
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int num = 1;
        while(true) {
            int tenth = (int) Math.pow(10, num);
            if(n > tenth) {
                n = (n + 5*tenth/10)/tenth * tenth;
            } else {
                break;
            }
            num++;
        }
        bw.write(n + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
