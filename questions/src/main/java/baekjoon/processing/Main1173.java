package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken());
        int initialPulse = Integer.parseInt(st.nextToken());
        int maxPulse = Integer.parseInt(st.nextToken());
        int pulseRise = Integer.parseInt(st.nextToken());
        int pulseDrop = Integer.parseInt(st.nextToken());
        //연산
        int count = 0;
        int minute = 0;
        int pulse = initialPulse;
        while(count < goal) {
            minute++; //어쨌든 시간은 간다
            if(initialPulse + pulseRise > maxPulse) { //운동 불가능 확인
                break;
            } else if(pulse + pulseRise <= maxPulse) { //운동 가능 확인
                count++;
                pulse += pulseRise;
            } else {
                if(pulse - pulseDrop >= initialPulse) //일반 휴식
                    pulse -= pulseDrop;
                else //최초맥박보다 낮을 경우 최초맥박 사용
                    pulse = initialPulse;
            }
        }
        //출력
        if(count < goal) bw.write(-1 + "\n");
        else bw.write(minute + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
