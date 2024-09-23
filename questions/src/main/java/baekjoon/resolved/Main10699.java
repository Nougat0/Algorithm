package baekjoon.resolved;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Main10699 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //서울 오늘 날짜 구하기
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul")); //KST는 안된다...
        //출력
        bw.write(sdf.format(today));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
