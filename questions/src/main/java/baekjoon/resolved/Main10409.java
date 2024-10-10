package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫째줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tasks = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int progress = 0, completed = 0;
        //둘째줄 입력 + 연산
        st = new StringTokenizer(br.readLine());
        int nextTask;
        while( completed < tasks /*모든 일을 다 했을 때는 while문 종료*/
            && (progress + (nextTask = Integer.parseInt(st.nextToken()))) <= time /*time을 초과하는 일부터는 while문 종료*/
        ) {
            progress += nextTask; //총 소요시간
            completed++; //완료된 일
        }
        //출력
        bw.write(completed + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
