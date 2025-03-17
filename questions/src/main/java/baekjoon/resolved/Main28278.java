package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28278 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n =Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            switch(order) {
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case 2:
                    if(stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.pop());
                    sb.append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if(stack.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case 5:
                    if(stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.peek());
                    sb.append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
