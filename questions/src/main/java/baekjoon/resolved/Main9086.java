package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9086 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9086
        https://www.acmicpc.net/source/78124588
        2024.05.10
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        //입력받은 후 바로 출력
        for(int i=0; i<t; i++) {
            char[] strArr = br.readLine().toCharArray();
            System.out.println(
                String.valueOf(strArr[0]) +
                String.valueOf(strArr[strArr.length -1])
            );
        }
    }
}
