package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int start = 0, end = 0, number, maxHeight = 0;
        for(int i=0; i<length; i++) {
            number = Integer.parseInt(st.nextToken());
            if(i==0) {
                start = number; /* 오르막길 시작 */
                end = number; /* 오르막길 끝 */
            } else {
                if(end < number) { /* 오르막길 진행 */
                    end = number;
                    // ** 최고높이 갱신
                    if(maxHeight < end - start) {
                        maxHeight = end - start;
                    }
                } else if(end >= number) { /* 오르막길 종료 */
                    // ** 최고높이 갱신 (오르막길이 있었을 경우에만)
                    if(start != end && maxHeight < end - start) {
                        maxHeight = end - start;
                    }
                    start = number;
                    end = number;
                }
            }
        }
        bw.write(maxHeight + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
