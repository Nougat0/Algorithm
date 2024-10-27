package baekjoon.resolved;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main10426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        String date = st.nextToken();
        int daysFrom = Integer.parseInt(st.nextToken()) - 1;
        //라이브러리 활용 + 출력
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDt = LocalDate.parse(date, formatter);
        LocalDate printDt = startDt.plusDays(daysFrom);

        bw.write(printDt.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
