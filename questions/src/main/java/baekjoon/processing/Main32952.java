package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main32952 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32952
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long r = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long wavesHit= m/k;
        for(int i=0; i<wavesHit; i++) {
            r /= 2;
        }
        System.out.println(r);
        br.close();
    }
}
