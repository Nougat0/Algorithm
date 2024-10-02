package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main15803 {
    public static final String aligned = "WHERE IS MY CHICKEN?";
    public static final String notAligned = "WINNER WINNER CHICKEN DINNER!";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st;
        double[][] location = new double[3][2];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            location[i][0] = Double.parseDouble(st.nextToken()); //x 좌표
            location[i][1] = Double.parseDouble(st.nextToken()); //y 좌표
        }
        /*
        직선방정식 기울기 연산
        (y = ax+b // y-ax = b // y'-y = ax'-ax // a = y'-y / x'-x )
         */
        if((location[0][1]-location[1][1])/(location[0][0]-location[1][0])
                == (location[1][1]-location[2][1])/(location[1][0]-location[2][0]))
            bw.write(aligned);
        else bw.write(notAligned);

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
