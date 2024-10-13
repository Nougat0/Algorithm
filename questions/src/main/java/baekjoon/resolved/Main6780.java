package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t1 = Integer.parseInt(br.readLine());
        int t2 = Integer.parseInt(br.readLine());
        int sequenceSize = 2; //크기만 확인 - 굳이 배열일 필요가 없음
        int nextSequence;
        while((nextSequence = t1-t2) >= 0) { //새 시퀀스 값 도출 가능할 때만
            t1 = t2; //한 칸씩 밀어넣기
            t2 = nextSequence; //새로운 sequence 값 도출
            sequenceSize++;
        }
        bw.write(sequenceSize + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
