package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main32279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int totalCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] elements = new int[totalCnt]; //이전 element가 규칙적으로 있어야 하므로 배열 사용
        elements[0] = Integer.parseInt(br.readLine());
        //연산
        long sum = elements[0]; // 1은 먼저 넣어놓기
        for(int i=2; i<=totalCnt; i++) { //2 ~ totalCnt 번호 사용, 배열에 넣거나 사용 시에는 번호-1
            if(i%2 == 0) elements[i-1] = elements[i/2-1] * p + q;
            else elements[i-1] = elements[i/2-1] * r + s;
            sum += elements[i-1];
        }
        //출력
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
