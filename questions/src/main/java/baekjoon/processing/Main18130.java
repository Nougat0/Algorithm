package baekjoon.processing;

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
        int[] fanInfo;
        
        long leastExpense = Long.MAX_VALUE;
        short leastFan = -1;
        //손풍기 기기별 비용 예상
        for(short i=0; i<n; i++) {
            fanInfo = new int[3]; //저장: [0]손풍기 가격, [1]추가비용 부과시간, [2]추가비용
            st = new StringTokenizer(br.readLine());
            for(short j=0; j<3; j++) fanInfo[j] = Integer.parseInt(st.nextToken());
            //비용 계산
            long expense = fanInfo[0]; //손풍기 가격
            int timeflow = fanInfo[1], section = 1; //추가비용 첫 구간으로 초기화
            while(timeflow < time) {
                //추가비용 부과
                expense += section*fanInfo[2];
                //다음 추가비용 부과구간
                timeflow += fanInfo[1];
                section++;
            }
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
