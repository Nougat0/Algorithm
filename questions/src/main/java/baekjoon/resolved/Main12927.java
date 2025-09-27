package baekjoon.resolved;

import java.io.*;

public class Main12927 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/12927
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력
        String line = br.readLine();
        int lastIndex = line.length();
        boolean[] bulbs = new boolean[lastIndex+1];
        for(int i=1; i<=lastIndex; i++) {
            bulbs[i] = line.charAt(i-1) == 'Y';
        }
        //누르기
        int pressCount = 0;
        for(int i=1; i<=lastIndex; i++) {
            if(checkOff(bulbs, lastIndex)) break;
            //배수 스위치 누르기
            if(bulbs[i]) {
                pressSwitch(bulbs, i, lastIndex);
                pressCount++;
            }
        }
        //모든 전구를 끌 수 없었음 예외처리
        if(!checkOff(bulbs, lastIndex)) {
            pressCount = -1;
        }
        System.out.println(pressCount);
        br.close();
    }

    /**
     * 전구가 전부 꺼졌는지 확인
     * @param bulbs
     * @return true when at least one is ON, false when all is off;
     */
    public static boolean checkOff(boolean[] bulbs, int lastIndex) {
        for(int i=1; i<=lastIndex; i++) {
            if(bulbs[i]) return false;
        }
        return true;
    }

    /**
     * number번과 그 배수의 전구 전부 끄기
     * @param bulbs
     * @param number
     * @param lastIndex
     */
    public static void pressSwitch(boolean[] bulbs, int number, int lastIndex) {
        for(int i=number; i<=lastIndex; i+=number) {
            // 전구 반전
            if(bulbs[i]) bulbs[i] = false;
            else bulbs[i] = true;
        }
    }
}
