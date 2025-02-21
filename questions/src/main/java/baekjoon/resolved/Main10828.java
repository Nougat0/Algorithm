package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        /*Stack 구현체 사용*/
        Stack<Integer> stack = new Stack<>();
        int orders = Integer.parseInt(br.readLine());
        for(int o=0; o<orders; o++) {
            boolean nextLine = true;
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            char c = order.charAt(0);
            switch(c) {
                case 's':
                    sb.append(stack.size()); break;
                case 'e':
                    sb.append(stack.empty() ? 1 : 0); break;
                case 't':
                    sb.append(stack.empty() ? -1 : stack.peek()); break;
                default:
                    int length = order.length(); //문자열 길이
                    if(length == 4) { //push
                        stack.push(Integer.parseInt(st.nextToken()));
                        nextLine = false;
                    } else { //pop
                        sb.append(stack.empty() ? -1 : stack.pop());
                    }
            }
            if(nextLine) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
