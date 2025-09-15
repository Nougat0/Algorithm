package baekjoon.resolved;

import java.io.*;

public class Main2164 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2164
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);

        while(queue.size() > 2) {
            queue.dequeue(); // 1)맨 위 카드 버리기
            queue.enqueue(queue.dequeue()); // 2)맨 위 카드 아래로 넣기
        }
        int result;
        if (queue.size() > 1) { //하나 더 버리기
            queue.dequeue();
        }
        result = queue.dequeue();
        System.out.println(result);
        br.close();
    }

    public static class Queue {
        int front; //맨앞
        int rear; //맨뒤
        int[] queue;

        //초기화 생성자
        public Queue(int size) {
            front = rear = 0;
            queue = new int[size*2];
            for(int i=1; i<=size; i++) {
                rear++;
                queue[rear] = rear;
            }
        }

        public void enqueue(int number) {
            queue[++rear] = number;
        }

        public int dequeue() {
            //First In, First Out
            return queue[++front];
        }

        public int size() {
            return rear - front;
        }
    }
}
