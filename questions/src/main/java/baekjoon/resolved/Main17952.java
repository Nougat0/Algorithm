package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17952 {
    /*
        https://www.acmicpc.net/problem/17952
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int duration = Integer.parseInt(br.readLine());
        Stack<Integer> taskRemains = new Stack<>();
        Stack<Integer> taskPoints = new Stack<>();
        int earnedPoints = 0; //누적 점수
        //지금 하고 있는 과제는 Stack에서 꺼낸 상태
        int currentTaskRemains = 0;
        int currentTaskPoint = 0;
        while(duration-- > 0) {
            st = new StringTokenizer(br.readLine());
            int newTask = Integer.parseInt(st.nextToken());
            if(newTask == 1) {
                //[1] 새로운 과제 발생
                int point = Integer.parseInt(st.nextToken());
                int remains = Integer.parseInt(st.nextToken());
                //진행중인 과제 넣어두기
                if(currentTaskRemains > 0) {
                    taskRemains.push(currentTaskRemains);
                    taskPoints.push(currentTaskPoint);
                }
                currentTaskRemains = remains - 1; //받자마자 시작
                currentTaskPoint = point;
            } else if(currentTaskRemains > 0) {
                //[2] 과제 없음 + 진행중인 과제 존재
                currentTaskRemains--;
            }
            //완료된 과제 체크
            if(currentTaskRemains == 0) {
                earnedPoints += currentTaskPoint;
                //다음 과제 꺼내기
                if(!taskRemains.isEmpty()) {
                    currentTaskRemains = taskRemains.pop();
                    currentTaskPoint = taskPoints.pop();
                } else {
                    currentTaskPoint = 0; //진행 과제 없으니 점수도 초기화
                }
            }
        }
        bw.write(earnedPoints + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
