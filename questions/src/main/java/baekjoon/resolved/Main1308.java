package baekjoon.resolved;

import java.io.*;
import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class Main1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st;
        int[][] date = new int[2][3];
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                date[i][j] = Integer.parseInt(st.nextToken());
        }
        //연산
        LocalDate startDt = LocalDate.of(date[0][0], date[0][1], date[0][2]);
        LocalDate endDt = LocalDate.of(date[1][0], date[1][1], date[1][2]);
        long daysBetween = ChronoUnit.DAYS.between(startDt, endDt);
        Period duration = Period.between(startDt, endDt);
        //출력
        if(duration.getYears() >= 1000) bw.write("gg");
        else bw.write("D-" + daysBetween);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
