package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5671 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        //테스트 케이스
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int rooms = 0;
            for(int i=min; i<=max; i++) {
                boolean[] numbers = new boolean[10];
                char[] number = String.valueOf(i).toCharArray();
                int index = 0, count = 0, length = number.length;
                // 중복숫자가 나올 때까지 방번호 등장 숫자 탐색
                while(index < length && !numbers[number[index] - 48]) {
                    numbers[number[index++] - 48] = true;
                    count++;
                }
                // 방 번호 길이보다 짧을 시 중복 등장
                // count와 길이가 같을 경우에만 해당 번호 사용
                if(count == length) rooms++;
            }
            sb.append(rooms).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
