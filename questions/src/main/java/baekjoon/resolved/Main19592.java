package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main19592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] speed; //각 후보의 속도
        double[] duration; //각 후보의 걸린시간
        int testCase = Integer.parseInt(br.readLine());
        int n, x, y; //번호, 트랙 길이, 부스터 한계치
        for(int i=0; i<testCase; i++) {
            int winner = 1001; //우승후보 (초기값)
            double winnerScore = Double.MAX_VALUE; //우승시간 (초기값)
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            speed = new int[n];
            duration = new double[n];
            //우승후보 색출
            for(int j=0; j<n; j++) {
                speed[j] = Integer.parseInt(st.nextToken());
                duration[j] = (double) x / speed[j];
                if(duration[j] < winnerScore) {
                    winner = j;
                    winnerScore = duration[j];
                }
            }
            if(winner == n-1) { /* 부스터 없이도 우승 */
                sb.append(0);
            } else { /* 부스터 사용해야 함 */
                int minSpeed = -1;
                for(int j=speed[n-1]+1; j<=y; j++) {
                    //1초간 부스터 사용 -> 속도(1초)만큼 빼기
                    if(1 + (double) (x-j) / speed[n-1] < winnerScore) {
                        minSpeed = j;
                        break;
                    }
                }
                sb.append(minSpeed);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
