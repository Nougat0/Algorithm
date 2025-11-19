package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2991 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2991
    */
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
            int arrival = Integer.parseInt(st.nextToken());
            sb.append(getAttackedTimes(arrival)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getAttackedTimes(int arrival) {
        int aCycle = a+b;
        int bCycle = c+d;
        int count = 0;
        //cycle 과 동일하게 도착할 경우 쉬는 중임
        if(aCycle > arrival && arrival <= a) count++;
        else if(aCycle < arrival && arrival % aCycle <= a) count++;
        if(bCycle > arrival && arrival <= c) count++;
        else if(bCycle < arrival && arrival % bCycle <= c) count++;
        return count;
    }
}
