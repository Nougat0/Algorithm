package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1076 {
    public enum ResistorColor { //값이 정해져 있으므로 enum 으로 정의, 순서 가져오기
        black, brown, red, orange, yellow, green, blue, violet, grey, white;
        private static int getOrdinal(String color) {
            try{
                return ResistorColor.valueOf(color).ordinal();
            } catch(Exception e) {
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String value = String.format("%d%d",
                ResistorColor.getOrdinal(br.readLine()),
                ResistorColor.getOrdinal(br.readLine()));
        //black이 곱으로 올 경우 대비 (*1 이므로 동작 없음)
        int multiply = ResistorColor.getOrdinal(br.readLine());
        if(multiply != 0) value += String.format("%0"+multiply+"d", 0);

        //black이 값으로 올 경우 대비
        bw.write(Long.valueOf(value) + "\n"); //21억을 가뿐히 넘기기 때문에 Long
        bw.flush();
        bw.close();
        br.close();
    }
}
