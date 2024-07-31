package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //공통 글자 확인, horizontal 기준으로 가장 첫 번째로 오는 중복 위치 가져오기
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] horizontal = st.nextToken().toCharArray(); // 단어 A
        char[] vertical = st.nextToken().toCharArray(); // 단어 B
        int horizonCross = -1, verticalCross = -1;

        gotCrossPosition: //공통 글자 찾으면 loop 중단
        for(int i=0; i<horizontal.length; i++)
            for(int j=0; j<vertical.length; j++)
                if(horizontal[i] == vertical[j]) {
                    //공통글자 위치 가져오기
                    horizonCross = i;
                    verticalCross = j;
                    break gotCrossPosition;
                }
        //공통 글자 기준으로 출력
        for(int i=0; i<vertical.length; i++) {
            for(int j=0; j<horizontal.length; j++)
                if(j==horizonCross)  bw.write(vertical[i]);
                else if(i==verticalCross)  bw.write(horizontal[j]);
                else  bw.write(".");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
