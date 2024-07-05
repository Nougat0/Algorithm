package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][] board = new boolean[8][8]; //F: true, .: false
        for(int i=0; i<8; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<8; j++)
                board[i][j] = arr[j] == 'F';
        }

        /*
        흰칸과 올려진칸 대조하기
        [0, 0]은 흰칸 --> [홀, 홀], [짝, 짝]은 흰칸
         */
        int count = 0;
        for(int i=0; i<8; i++)
            for(int j=0; j<8; j++)
                if((i+j) % 2 == 0 && board[i][j])
                    count++;
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
