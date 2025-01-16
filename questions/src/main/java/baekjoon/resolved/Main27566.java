package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main27566 {
    /*
    블루베리 와플 (팬) 동작
    * r초마다(동안) 180도 회전(뒤집어짐)
    * f초가 지났을 때 동작 멈춤
    * 동작을 멈췄을 때 수평이 아니라면 수평이 되게끔 조정됨(위로든 아래든 가장 가까운 방향으로)
    * 세로로 수직인 채로 멈추는 경우는 없는 것으로 생각하기
    * 처음에는 블루베리가 위로 향한 채로 시작
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rotateDuration = Integer.parseInt(st.nextToken());
        int stopTime = Integer.parseInt(st.nextToken());
        /*
         * 회전 시간의 전반에서 멈출때는 안 뒤집힌 상태,
         * 후반에서 멈출때는 뒤집힌 상태
         */
        boolean front = true; //true: 앞면, false: 뒷면
        double halfRotate = rotateDuration / 2.0;
        int loop = 2*rotateDuration;
        //뒷면인 경우 확인
        if(stopTime > halfRotate) {
            stopTime -= halfRotate; //새로운 loop 확인용 시간 빼기
            if(stopTime % loop < rotateDuration) {
                front = false; //뒷면
            }
        }
        bw.write(front ? "up" : "down");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
