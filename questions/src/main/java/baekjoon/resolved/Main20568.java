package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main20568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int studentCnt = Integer.parseInt(br.readLine());
        int[] students = new int[studentCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cryingCnt = 0;
        int cryingMinValue;
        //입력
        for(int i=0; i<studentCnt; i++) students[i] = Integer.parseInt(st.nextToken());
        //오름차순 정렬
        Arrays.sort(students);
        //개수 세기
        cryingMinValue = students[0];
        for(int i=1; i<studentCnt; i++) {
            if(cryingMinValue >= students[i]) cryingCnt++;
            else cryingMinValue = students[i];
        }
        bw.write(cryingCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
