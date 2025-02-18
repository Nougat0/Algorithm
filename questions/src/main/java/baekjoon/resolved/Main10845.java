package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int orders = Integer.parseInt(br.readLine());
        Queue que = new Queue();
        for(int o=0; o<orders; o++) {
            boolean nextLine = true;
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            char c = order.charAt(0);
            switch(c) {
                case 's':
                    sb.append(que.size()); break;
                case 'e':
                    sb.append(que.empty()); break;
                case 'f':
                    sb.append(que.front()); break;
                case 'b':
                    sb.append(que.back()); break;
                default:
                    int length = order.length(); //문자열 길이
                    if(length == 4) { //push
                        que.push(Integer.parseInt(st.nextToken()));
                        nextLine = false;
                    } else sb.append(que.pop());
            }
            if(nextLine) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Queue {
        //가장 앞의 위치 기록용 변수
        //pop 때 정수 제거하는 대신 "가장 앞" 위치를 한 칸씩 당김
        int min;
        List<Integer> queue; //큐
        public Queue() {
            this.min = 0;
            this.queue = new ArrayList<>();
        }

        /*파라미터 x queue에 추가*/
        public void push(int x) {
            queue.add(x);
        }
        /*queue 가장 앞의 정수 제거 후 반환*/
        public int pop() {
            if(size() == 0) {
                return -1;
            } else {
                return queue.get(min++);
            }
        }
        /*queue의 크기 반환*/
        public int size() {
            //가장 앞의 위치 고려해서 크기 반환
            return queue.size() - min;
        }
        /*queue가 비어있는지 확인, 결과값 반환
        * 비어있다 = 1, 정수 존재 = 0*/
        public int empty() {
            if(size() == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        /*가장 앞의 정수 반환*/
        public int front() {
            if(size() == 0) {
                return -1;
            } else {
                return queue.get(min);
            }
        }
        /*가장 마지막 정수 반환*/
        public int back() {
            if(size() == 0) {
                return -1;
            } else {
                int maxIndex = queue.size()-1;
                return queue.get(maxIndex);
            }
        }
    }
}
