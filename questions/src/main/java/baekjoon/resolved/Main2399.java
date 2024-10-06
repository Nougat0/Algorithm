package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int numbers = Integer.parseInt(br.readLine());
        int[] coordinate = new int[numbers];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<numbers; i++) coordinate[i] = Integer.parseInt(st.nextToken());
        //연산
        long sum = 0;
        for(int i=0; i<numbers-1; i++)
            for(int j=i+1; j<numbers; j++)
                sum += Math.abs(coordinate[i] - coordinate[j]);
        //출력
        bw.write(sum*2 + "\n"); // |x[i]-x[j]| == |x[j]-x[i]| 이므로 2배
        bw.flush();
        bw.close();
        br.close();
    }
}
