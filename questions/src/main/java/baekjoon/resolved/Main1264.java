package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            int count = 0;
            String line = br.readLine();
            if(line.equals("#")) break;
            else {
                char[] lineChar = line.toUpperCase().toCharArray();
                for(int i=0; i<lineChar.length; i++)
                    if(lineChar[i] == 'A'||
                       lineChar[i] == 'E'||
                       lineChar[i] == 'I'||
                       lineChar[i] == 'O'||
                       lineChar[i] == 'U') count++;
            }
            bw.write(count +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
