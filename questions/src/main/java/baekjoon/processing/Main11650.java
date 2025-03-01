package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main11650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int dotCnt = Integer.parseInt(br.readLine());
        int[][] dots = new int[dotCnt][2];
        for(int i=0; i<dotCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i][0] = x;
            dots[i][1] = y;
        }
        //정렬 (Comparator 커스텀 정의)
        Collections.sort(Arrays.asList(dots), (o1, o2) -> {
            //return o1-o2 오름차순 (양수: o2부터, 음수: o1부터)
            if(o1[0] > o2[0]) { //o1가 x좌표가 더 큰 상황
                return 1;
            } else if(o1[0] == o2[0] && o1[1] > o2[1]) { //x는 동일하고 o1이 y만 더 큰 상황
                return 1;
            } else {
                return -1;
            }
        });
        //출력
        for(int i=0; i<dotCnt; i++) {
            sb.append(dots[i][0]).append(' ').append(dots[i][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
