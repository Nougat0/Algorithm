package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2752 {
    /*
        https://www.acmicpc.net/problem/2752
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[] {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };
        Arrays.sort(numbers); //오름차순 정렬
        sb.append(numbers[0]).append(' ').append(numbers[1]).append(' ').append(numbers[2]);
        System.out.println(sb);
        br.close();
    }
}
