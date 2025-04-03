package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int developTime, runCnt, serialRuntime, parallelRuntime, parallelWorkLoad;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            developTime = Integer.parseInt(st.nextToken()); //병렬 개발시간
            runCnt = Integer.parseInt(st.nextToken()); //실행횟수
            serialRuntime = Integer.parseInt(st.nextToken()); //직렬 1회 소요시간
            parallelRuntime = Integer.parseInt(st.nextToken()); //병렬 1회 소요시간
            //직렬 <-> 병렬 :: 전체 소요 시간 비교
            parallelWorkLoad = developTime + parallelRuntime*runCnt; //병렬 전체 소요시간(작업량)
            if(serialRuntime*runCnt > parallelWorkLoad) sb.append("parallelize");
            else if(serialRuntime*runCnt < parallelWorkLoad) sb.append("do not parallelize");
            else sb.append("does not matter");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
