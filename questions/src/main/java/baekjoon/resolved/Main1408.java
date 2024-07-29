package baekjoon.resolved;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main1408 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date nowTime = format.parse(br.readLine());
        Date startTime = format.parse(br.readLine());
        Date endTime = (Date) startTime.clone();
        endTime.setTime(endTime.getTime() + TimeUnit.DAYS.toMillis(1));
        long diff;

        if(nowTime.before(startTime)) { //현재시간이 더 작을 경우 자정을 넘긴 것으로 간주
            nowTime.setTime(nowTime.getTime() + TimeUnit.DAYS.toMillis(1));
        }

        diff = endTime.getTime() - nowTime.getTime();
        long hour = TimeUnit.MILLISECONDS.toHours(diff);
        long min = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
        long sec = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;

        bw.write(String.format("%02d:%02d:%02d", hour, min, sec));

        bw.flush();
        bw.close();
        br.close();
    }
}
