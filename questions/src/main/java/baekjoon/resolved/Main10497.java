package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main10497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        byte targets = Byte.parseByte(br.readLine());
        int[][] targetList = new int[targets][5];
        for(byte t=0; t<targets; t++) {
            st = new StringTokenizer(br.readLine());
            targetList[t][0] = (st.nextToken().charAt(0) == 'r' ? 1 : 0);
            /*좌표 정보 입력*/
            byte index = 1;
            while(st.hasMoreTokens()) {
                //사각형: x1 y1 (왼쪽 아래) x2 y2 (오른쪽 위)
                //원: x y (중심) r (반지름)
                targetList[t][index++] = Integer.parseInt(st.nextToken());
            }
        }
        byte shots = Byte.parseByte(br.readLine());
        for(byte s=0; s<shots; s++) {
            byte takenTargets = 0;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int[] target : targetList) {
                if(target[0] == 1) { //사각형
                    if(x >= target[1] && x <= target[3] && y >= target[2] && y <= target[4])
                        takenTargets++;
                } else { //원
                    if(Math.pow(x - target[1], 2) + Math.pow(y - target[2], 2) <= Math.pow(target[3], 2))
                        takenTargets++;
                }
            }
            sb.append(takenTargets).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
