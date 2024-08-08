package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main1440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        사실상 시 부분에 올 숫자만 제약사항이 있고, 그 외의 분, 초는 입력값 모든 범위가 유효함
        따라서 시가 될 수 있는지만 확인해서 count
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int count = 0;
        int[] time = new int[3];
        for(int i=0; i<3; i++) { //입력과 동시에 체크하기
            time[i] = Integer.parseInt(st.nextToken());
            if(time[i] > 0 && time[i] <= 12)
                count += 2; //분, 초 배치 경우의 수 : 2
        }
        //출력
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
