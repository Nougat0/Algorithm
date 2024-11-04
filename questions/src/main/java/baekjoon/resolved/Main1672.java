package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1672 {
    static final int[][] baseMap = new int[][] {{0, 2, 0, 1}, {2, 1, 3, 0}, {0, 3, 2, 1}, {1, 0, 1, 3}}; //미리 제공된 해독용 표
    static final List<Character> nucleicOrder = new ArrayList<>(List.of('A', 'G', 'C', 'T')); //염기서열 숫자 1:1 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        //염기서열 입력받아서 int[] 로 변환
        //미리 제공된 표에 나와있듯이 A(0), G(1), C(2), T(3) -> nucleicOrder 에 저장해놓기
        char[] list = br.readLine().toCharArray();
        int[] listToInt = new int[length];
        for(int i=0; i<length; i++) listToInt[i] = nucleicOrder.indexOf(list[i]);

        //염기서열 해독
        for(int i=length-1; i>0; i--) {
            listToInt[i-1] = baseMap[listToInt[i-1]][listToInt[i]];
        }
        bw.write(String.format("%c%n", nucleicOrder.get(listToInt[0])));
        bw.flush();
        bw.close();
        br.close();
    }
}
