package baekjoon.resolved;

import java.io.*;

public class Main4999 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4999
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int patient = br.readLine().length();
        int doctor = br.readLine().length();
        System.out.println(doctor <= patient ? "go" : "no");
        br.close();
    }
}
