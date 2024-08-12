package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer initData, move;
        int scenario = 1;
        while(true) {
            initData = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(initData.nextToken());
            int w = Integer.parseInt(initData.nextToken());
            if(o == 0 && w == 0) break; //전체 시나리오 중단
            Pet pet = new Pet(o, w);
            //작용
            while(true) {
                move = new StringTokenizer(br.readLine());
                String action = move.nextToken();
                int n = Integer.parseInt(move.nextToken());
                //동작
                if(action.equals("#"))  { //현재 시나리오 중단
                    bw.write(String.format("%d %s%n", scenario, pet.getStatus()));
                    break;
                }
                else if(!pet.checkIsAlive()) continue; //건너뛰기
                else if(action.equals("E")) pet.exercise(n); //운동
                else pet.eat(n); //밥먹기
            }
            scenario++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 펫의 적정 체중, 현재 체중 관리용 클래스
     */
    public static class Pet {
        private int o;
        private int w;
        public Pet(int o, int w) {
            this.o = o;
            this.w = w;
        }
        public void exercise(int time) {
            this.w -= time;
        }
        public void eat(int food) {
            this.w += food;
        }
        public boolean checkIsAlive() {
            return this.w > 0;
        }
        public String getStatus() {
            if(!checkIsAlive()) return "RIP";
            else if(2*w > o && w < o*2) return ":-)";
            else return ":-(";
        }
    }
}
