package baekjoon.processing;

import java.io.*;
import java.util.Arrays;

public class Main1343 {
    static String[] polyomino = new String[] {"AAAA", "BB"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String board = br.readLine();
        String[] sectionList = board.split("\\.+");
        for(String section: sectionList) {
            //각 구역에 대해 채워넣기
            int length = section.length();
            for(int i=length/polyomino[0].length(); i>=0; i--) {
                if(i*polyomino[0].length() < length) {
                    if((length - i*polyomino[0].length()) % polyomino[1].length() == 0){
                        sb.append("");
                    }
                } else if(i*polyomino[0].length() == length) {
                    sb.append(polyomino[0].repeat(i));
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
