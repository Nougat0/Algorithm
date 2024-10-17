package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main28239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력 + 연산
        int menuCnt = Integer.parseInt(br.readLine());
        int[] menuList = new int[menuCnt];
        for(int i=0; i<menuCnt; i++) {
            menuList[i] = Integer.parseInt(br.readLine());
            char[] binary = Integer.toBinaryString(menuList[i]).toCharArray();
            int x = -1, y = -1, length = binary.length, idx = length;
            while(x == -1 || y == -1) { // x, y 값을 모두 찾을 때까지 반복
                if(binary[length - idx] == '1') //애초에 x=y 일 수가 없지 않나...?
                    if(y == -1) y = idx-1;
                    else x = idx-1;
                idx--;
            }
            sb.append(x).append(" ").append(y).append("\n");
        }
        //출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
