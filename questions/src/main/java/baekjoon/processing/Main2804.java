package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //공통 글자 확인, horizontal 기준으로 가장 첫 번째로 오는 중복 위치 가져오기
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] horizontal = st.nextToken().toCharArray();
        char[] vertical = st.nextToken().toCharArray();
        int horizonCross = -1, verticalCross = -1;

        gotCrossPosition:
        for(int i=0; i<horizontal.length; i++)
            for(int j=0; j<vertical.length; j++)
                if(horizontal[i] == vertical[j]) {
                    horizonCross = i;
                    verticalCross = j;
                    break gotCrossPosition;
                }
        //출력
        for(int i=0; i<vertical.length; i++) {
            for(int j=0; j<horizontal.length; j++) {
                if(j==horizonCross)  bw.write(vertical[i]);
                else if(i==verticalCross)  bw.write(horizontal[j]);
                else  bw.write(".");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
