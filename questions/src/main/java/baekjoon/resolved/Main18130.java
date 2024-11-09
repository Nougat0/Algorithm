package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력, 연산
        short n = Short.parseShort(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        long[] fanInfo;
        
        long leastExpense = Long.MAX_VALUE;
        short leastFan = -1;
        //손풍기 기기별 비용 예상
        for(short i=0; i<n; i++) {
            fanInfo = new long[3]; //저장: [0]손풍기 가격, [1]추가비용 부과시간, [2]추가비용
            st = new StringTokenizer(br.readLine());
            for(short j=0; j<3; j++) fanInfo[j] = Long.parseLong(st.nextToken());
            //비용 계산
            long expense = fanInfo[0]; //손풍기 가격
            long quotient = (time-1)/fanInfo[1]; //도착시간과 비용내는 시간이 겹칠 때의 비용은 제외하기 위해 time-1
            expense += fanInfo[2] * ((quotient + 1) * (quotient/2) + (quotient%2 != 0 ? quotient/2+1 : 0));
            //최소비용인지 확인
            if(expense < leastExpense) {
                leastFan = (short) (i+1);
                leastExpense = expense;
            }
        }
        //출력
        sb.append(leastFan).append(" ").append(leastExpense);
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
