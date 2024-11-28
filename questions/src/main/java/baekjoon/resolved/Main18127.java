package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18127 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        (A -2) -> 추가되는 변의 개수
        (B + 1) -> 온도별로 추가되는 한 변의 길이 (0일 때는 0)
        (A -3) -> 각 layer에서 빼야할 개수
        ===========================================
        (B+1) * (A-2) - (A -3) => 각 온도(layer)별로 추가되는 개수
        ===========================================
        구해야 할 것: -B 도에서는 0도부터 -B 도까지의 온도별 추가개수의 누적합
        ===========================================
        A=3, B=4 입력받았을 때
        0: 1
        1: 2*1-0 (1+1)*1-0
        2: 3*1-0 (1+2)*1-0
        3: 4*1-0 (1+3)*1-0
        4: 5*1-0 (1+4)*1-0
        ===========================================
        1+2+3+4 -> (1+B)*(B/2) + (B%2==1 ? B/2 : 0)
        1+1+1+1 -> 1*B
        *1 4개 -> (A-2)
        -0 4개 -> (A-3)*B
        +1 -> +1
        ===========================================
        ((1+B)*(B/2) + (B%2 != 0 ? B/2 : 0) + 1*B) * (A-2) - (A-3)*B + 1
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int polygonSides = Integer.parseInt(st.nextToken());
        long minusDegrees = Integer.parseInt(st.nextToken());
        boolean isOdd = minusDegrees%2 == 1;
        long totalCrystals =
            ((1+minusDegrees)*(minusDegrees/2) + (isOdd ? minusDegrees/2+1 : 0) + (1*minusDegrees)) * (polygonSides-2) //모든 변의 결정 개수
            - (polygonSides-3)*minusDegrees //변들 겹치는 개수
            + 1; //0도일 때 결정 개수
        bw.write(totalCrystals + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
