package baekjoon.resolved;

import java.io.*;

public class Main34980 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34980
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String line2 = br.readLine();

        boolean equals = true;
        int lineCount = 0, line2Count = 0;
        for(int i=0; i<n; i++) {
            char c = line.charAt(i);
            char c2 = line2.charAt(i);
            if(c != c2) equals = false;
            if(c == 'w') lineCount++;
            if(c2 == 'w') line2Count++;
        }

        if(equals) System.out.println("Good");
        else if(lineCount == line2Count) System.out.println("Its fine");
        else if(lineCount < line2Count) System.out.println("Manners maketh man");
        else System.out.println("Oryang");
        br.close();
    }
}
