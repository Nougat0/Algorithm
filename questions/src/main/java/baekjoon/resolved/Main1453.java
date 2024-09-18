package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main1453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int totalCustomerCnt = Integer.parseInt(br.readLine()); //미사용
        br.readLine(); //미사용 처리
        int refusedCustomerCnt = 0;
        //false: 비어있는 자리, true: 선점된 자리
        boolean[] seatList = new boolean[100]; //피시방 자리 1~100
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int seatNo = Integer.parseInt(st.nextToken()) -1; //1번 -> 0번으로 시작
            if(seatList[seatNo]) refusedCustomerCnt++;
            else seatList[seatNo] = true;
        }
        bw.write(refusedCustomerCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
