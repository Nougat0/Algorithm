package baekjoon.processing;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main4197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        Turtle turtle;
        while(testCase-- > 0) {
            turtle = new Turtle();
            sb.append(turtle.processCommands()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Turtle {
        double degree; //각도
        double x, y; //좌표 추적
        double value; //전진 거리 / 변경 각도 값
        char command; //명령어 저장용 번수

        public Turtle() {
            this.x = 0;
            this.y = 0;
            this.degree = 0;
        }

        //명령 N개 입력받고 함수 호출하여 실행, 결과값 반환
        public String processCommands() throws IOException {
            int commandCnt = Integer.parseInt(br.readLine());
            while(commandCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                command = st.nextToken().charAt(0);
                value = Integer.parseInt(st.nextToken());
                processCommand(command, value);
            }
            return getDistance();
        }

        //개별 명령줄 실행
        private void processCommand(char command, double value) {
            //각도 조정
            switch(command) {
                case 'l': degree += value; break;
                case 'r': degree -= value; break;
                case 'b': degree += 180; break;
            }
            degree %= 360;
            //좌표 조정
            if(command == 'f' || command == 'b') {
                x += Math.cos(Math.toRadians(degree)) * value;
                y += Math.sin(Math.toRadians(degree)) * value;
            }
        }

        //0,0 (초기 좌표) 와 현재 좌표의 직선거리 구하기
        private String getDistance() {
            DecimalFormat df = new DecimalFormat("###.###");
            return df.format((Math.sqrt(x*x + y*y)));
        }
    }
}
