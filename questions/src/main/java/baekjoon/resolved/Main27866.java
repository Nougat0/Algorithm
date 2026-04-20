package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main27866 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27866
        https://www.acmicpc.net/source/78124375
        2024.05.10
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        //출력
        System.out.println(word.toCharArray()[Integer.parseInt(br.readLine())-1]);
    }
}