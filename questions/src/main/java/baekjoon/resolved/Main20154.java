package baekjoon.resolved;

import java.io.*;

public class Main20154 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/20154
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lines = new int[] {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
        //사실상 모든 수를 더해서 1의 자릿수를 확인하면 되는 것 같은데...
        char[] S = br.readLine().toCharArray();
        int sum = 0;
        for(char c : S) {
            sum += lines[c - 'A'];
        }
        System.out.println(sum % 2 == 0 ? "You're the winner?" : "I'm a winner!");
        br.close();
    }
}
