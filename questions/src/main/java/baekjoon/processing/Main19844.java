package baekjoon.processing;

import java.io.*;

public class Main19844 {
    /*
        https://www.acmicpc.net/problem/19844
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();
        int length = line.length;
        int splitCount = 0;
        int splitIndex = -1; //문장 맨 앞 분리처럼 취급
        for(int i=0; i<length; i++) {
            char c = line[i];
            switch(c) {
                case ' ': case '-':
                    splitIndex = i;
                    splitCount++;
                    i++;
                    break;
                case '\'':
                    boolean formerCheck = false, latterCheck = false;
                    if(i-1 - splitIndex <= 2) { // '를 제외한 문자열 길이
                        switch(line[i+1]) {
                            case 'a': case 'e': case 'i': case 'o': case 'u': case 'h':
                                latterCheck = true;
                                break;
                        }
                        switch(line[i-1]) {
                            case 'c': case 'j': case 'n': case 'm': case 't': case 's': case 'l': case 'd':
                                formerCheck = true;
                                break;
                            case 'u':
                                if(i-2 >=0 && line[i-2] == 'q')
                                    formerCheck = true;
                                break;
                        }
                        if(formerCheck && latterCheck) {
                            splitIndex = i;
                            splitCount++;
                        }
                    }
                    break;
            }
        }
        //분리된 개수보다 단어 개수가 1개 더 많음
        bw.write((splitCount + 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
