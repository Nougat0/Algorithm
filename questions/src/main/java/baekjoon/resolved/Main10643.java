package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10643 {
    final static int slices = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int[] slice = new int[slices];
        int maxMushrooms = 0;
        for(int i=0; i<slices; i++) {
            slice[i] = Integer.parseInt(br.readLine());
        }
        //연산
        for(int i=0; i<slices; i++) { //선두에 선 피자조각: i
            int total = 0;
            //시계방향으로 연이은 피자 4조각 조사
            for(int j=0; j<4; j++) {
                int newIndex = i+j > (slices-1) ? i+j-slices : i+j;
                total += slice[newIndex];
            }
            //버섯 최대값 갱신
            if(total > maxMushrooms) maxMushrooms = total;
        }
        //출력
        bw.write(maxMushrooms + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
