package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9843 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9843
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int register = 0;
        int n = Integer.parseInt(br.readLine());
        String[] instructions = new String[n];
        for(int i=0; i<n; i++) {
            instructions[i] = br.readLine();
        }
        program:
        for(int i=0; i<n; i++) {
            String input = instructions[i];
            switch(input.charAt(0)) {
                case 'P':
                    if(input.charAt(1) == 'L') {
                        int plus = stack.pop() + stack.pop();
                        stack.push(plus);
                    } else {
                        int number = Integer.parseInt(input.split(" ")[1]);
                        stack.push(number);
                    }
                    break;
                case 'S':
                    register = stack.pop();
                    break;
                case 'L':
                    stack.push(register);
                    break;
                case 'T':
                    int multiply = stack.pop() * stack.pop();
                    stack.push(multiply);
                    break;
                case 'I':
                    int index = Integer.parseInt(input.split(" ")[1]);
                    if(stack.pop() == 0) i = index-1; //loop 다시 시작 시 1 더하니까
                    break;
                case 'D':
                    sb.append(stack.peek());
                    break program;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
