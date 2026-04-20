package baekjoon.resolved;

import java.util.*;
import java.io.*;

public class Main10951 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10951
        https://www.acmicpc.net/source/50494549
        2022.10.13
    */
    public static void main(String[]args) throws IOException {
        String[] sArr = new String[2];
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine())!= null){
            sArr = s.split(" ");
            System.out.println(Integer.parseInt(sArr[0])+Integer.parseInt(sArr[1]));
        }
        br.close();
    }///main
}///class