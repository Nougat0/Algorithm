package baekjoon.processing;

import java.io.*;

public class Main17294 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/17294
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        Long diff = null;

        boolean isCute = true;
        while((n/10 > 0)) {
            if(diff == null) {
                diff = n%10 - n%100/10;
            } else if(diff != n%10 - n%100/10) {
                isCute = false;
                break;
            }
            n /= 10;
        }
        System.out.println(isCute ? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!" : "흥칫뿡!! <(￣ ﹌ ￣)>");
        br.close();
    }
}
