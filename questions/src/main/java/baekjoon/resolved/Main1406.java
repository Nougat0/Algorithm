package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1406 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1406
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line = br.readLine();
        int n = line.length();
        int m = Integer.parseInt(br.readLine());

        //커서 초기화
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(int i=0; i<n; i++) {
            left.add(line.charAt(i));
        }
        //명령어 수행
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken().charAt(0)) {
                case 'L':
                    if(left.isEmpty()) continue;
                    right.push(left.pop());
                    break;
                case 'D':
                    if(right.isEmpty()) continue;
                    left.push(right.pop());
                    break;
                case 'B':
                    if(left.isEmpty()) continue;
                    left.pop();
                    break;
                default:
                    left.push(st.nextToken().charAt(0));
            }
        }
        //출력
        int leftLength = left.size();
        int rightLength = right.size();
        for(int i=0; i<leftLength; i++) {
            sb.append(left.get(i));
        }
        for(int i=rightLength-1; i>=0; i--) {
            sb.append(right.get(i));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
