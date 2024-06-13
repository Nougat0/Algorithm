package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            String testCase = br.readLine();
            int r = Integer.parseInt(testCase.split(" ")[0]);
            char[] s = testCase.split(" ")[1].toCharArray();
            String printLine = "";

            for(int j=0; j<s.length; j++) {
                printLine += new String(new char[r]).replace('\0', s[j]);
                //https://stackoverflow.com/a/4903603/23532292
            }
            System.out.println(printLine);
        }
    }
}
