package baekjoon.resolved;

import java.io.*;

public class Main10773 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10773
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack s = new Stack(k);
        int sum = 0;
        for(int i=0; i<k; i++) {
            int num = Integer.parseInt(br.readLine());
            //문제에서 EmptyStackException 발생할 일이 없음을 보장함
            if(num == 0) sum -= s.pop();
            else sum += s.push(num);
        }
        System.out.println(sum);
        br.close();
    }

    //직접 구현 시도
    public static class Stack {
        int current;
        int[] arr;

        public Stack(int k) {
            this.current = -1;
            this.arr = new int[k];
        }

        public int pop() {
            return arr[current--];
        }

        public int push(int n) {
            arr[++current] = n;
            return n;
        }
    }
}
