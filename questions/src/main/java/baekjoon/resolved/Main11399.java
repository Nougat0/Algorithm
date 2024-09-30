package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int peopleCnt = Integer.parseInt(br.readLine());
        int[] duration = new int[peopleCnt];
        long waitingSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<peopleCnt; i++)
            duration[i] = Integer.parseInt(st.nextToken());
        //정렬 및 연산
        Arrays.sort(duration); //인출시간이 적은 사람이 먼저 뽑도록 정렬
        for(int i=0; i<peopleCnt; i++)
            waitingSum += (peopleCnt-i) * duration[i];
        //출력
        bw.write(waitingSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
