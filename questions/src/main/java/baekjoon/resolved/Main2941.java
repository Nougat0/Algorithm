package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2941 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2941
        https://www.acmicpc.net/source/78398927
        2024.05.17
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        word = word.replaceAll("(c=)|(c-)|(dz=)|(d-)|(lj)|(nj)|(s=)|(z=)", "0");
        System.out.println(word.length());

        br.close();
    }
}
