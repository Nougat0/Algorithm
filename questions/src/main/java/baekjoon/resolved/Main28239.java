package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main28239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력 + 연산
        int menuCnt = Integer.parseInt(br.readLine());
        long[] menuList = new long[menuCnt];
        for(int i=0; i<menuCnt; i++) {
            menuList[i] = Long.parseLong(br.readLine());
            char[] binary = Long.toBinaryString(menuList[i]).toCharArray();
            int x = -1, y = -1, length = binary.length;
            for(int idx=length; idx>0; idx--) // x, y 값을 모두 찾을 때까지 반복
                if(binary[length - idx] == '1')
                    if(y == -1) y = idx-1;
                    else x = idx-1;
            if(x == -1) { // x==y 인 경우, y만 채워짐 -> 이전 index 2개가 있는 것
                x = y-1;
                y -= 1;
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
