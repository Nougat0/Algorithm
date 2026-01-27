package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10773 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10773
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> book = new Stack<>();
        int sum = 0;
        for(int i=0; i<k; i++) {
            int num = Integer.parseInt(br.readLine());
            //문제에서 EmptyStackException 발생할 일이 없음을 보장함
            if(num == 0) sum -= book.pop();
            else sum += book.push(num);
        }
        System.out.println(sum);
        br.close();
    }
}
