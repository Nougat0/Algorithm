package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        //a-b; //둘째날의 시작점. 매일매일 시작점에서 a만큼 올라가면 v에 닿는지 확인
        //a-b+a //둘째날의 최고점.
        //1:0, 1a-0b
        //2:a-b, 2a-b
        //3:2(a-b), 3a-2b
        //4:3(a-b), 4a-3b

        //day*a -(day-1)*b >= v
        //day(a-b) + b >= v
        //day >= (v-b)/(a-b)

        bw.write(String.format("%d%n", (v-b)/(a-b) + (v-b)%(a-b)));
        bw.flush();
        bw.close();
        br.close();
    }
}
