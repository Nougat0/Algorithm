package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main28454 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int[] today = new int[3];
        parseDate(today, st);
        int usable = 0;
        int gifts = Integer.parseInt(br.readLine());
        for(int i=0; i<gifts; i++) {
            st = new StringTokenizer(br.readLine(), "-");
            int[] date = new int[3];
            parseDate(date, st);
            if(compareDate(today, date)) usable++;
        }
        bw.write(usable + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void parseDate(int[] arr, StringTokenizer st) {
        for(int i=0; i<3; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    /**
     * today와 date 비교
     * 유효기간(date)가 today 이후인지 확인
     * @param today
     * @param date
     * @return today >= date : true, today < date : false
     */
    public static boolean compareDate(int[] today, int[] date) {
        /* 가독성 좋은 방식
        if(today[0] > date[0]) {
            return false;
        } else if(today[0] == date[0] && today[1] > date[1]) {
            return false;
        } else if(today[0] == date[0] && today[1] == date[1] && today[2] > date[2]) {
            return false;
        } else {
            return true;
        }
        */
        /* 실행할때 효율적인 방식 (중복체크 뺐음) */
        if(today[0] > date[0]) return false;
        else if(today[0] == date[0])
            if(today[1] > date[1]) return false;
            else if(today[1] == date[1])
                if(today[2] > date[2]) return false;
        return true;
    }
}
