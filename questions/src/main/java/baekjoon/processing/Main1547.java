package baekjoon.processing;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //컵의 위치정보를 담은 배열 - 순서대로 1번컵, 2번컵, 3번컵의 위치정보를 가짐
        Integer[] cups = new Integer[] {0, 1, 2}; 
        for(int i=0; i<n; i++) { //명시된 컵의 위치정보만 바꿔주기
            st = new StringTokenizer(br.readLine());
            int cup1 = Integer.parseInt(st.nextToken()) - 1;
            int cup2 = Integer.parseInt(st.nextToken()) - 1;
            int temp = cups[cup1];
            cups[cup1] = cups[cup2];
            cups[cup2] = temp;
        }
        //출력
        bw.write(Arrays.asList(cups).indexOf(0) + 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
