package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int rows = Integer.parseInt(st.nextToken());
        final int cols = Integer.parseInt(st.nextToken());
        final int length = Integer.parseInt(st.nextToken());

        boolean available;
        int emptyLength = 0;
        int availCases = 0;
        for(int i=0; i<rows; i++) {
            char[] row = br.readLine().toCharArray();
            for(int j=0; j<cols; j++) {
                available = row[j] == '0';
                if(available) emptyLength++;
                else {
                    //가능한 자리 취합 및 초기화
                    if(emptyLength >= length){
                        availCases += (emptyLength - length + 1);
                    }
                    emptyLength = 0;
                }
            }
            //가능한 자리 취합 및 초기화 (끝까지 비어있었을 경우)
            if(emptyLength >= length) {
                availCases += (emptyLength - length + 1);
            }
            emptyLength = 0;
        }
        bw.write(availCases + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
