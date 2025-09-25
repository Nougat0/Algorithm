package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main8029 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/8029
    */
    public static void main(String[] args) throws IOException {
        /** 문제 직접 해석해봄...
         * F 테이블: {0,1} Set의 숫자들로 구성된 테이블
         *           row/col 번호는 1~N까지
         *           F[col,row] = F[row][col] 의 값
         * [j][i] 와 [j'][i'] 2개 위치 사이의 거리는 i-i', j-j' 절대값 중 최대값
         * (가로나 세로 거리 중 더 큰 값)
         * 
         * W 테이블: W[j][i] = [j][i] 와 [y][x] 사이의 거리 <= R 인 모든 F[y][x]의 합
         *
         * W 테이블을 구해서 출력해라
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int R = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N+1][N+1];
        //F 테이블 입력
        for(int j=1; j<=N; j++) {
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                int number = st.nextToken().charAt(0) - '0';
                //누적합 구하기
                sum[j][i] = sum[j-1][i] + sum[j][i-1] - sum[j-1][i-1] + number;
            }
        }
        //W 테이블 값 계산 + 바로 출력
        for(int j=1; j<=N; j++) {
            for(int i=1; i<=N; i++) {
                //반경 R 의 네모
                int minJ = Math.max(j-R-1, 0);
                int maxJ = Math.min(j+R, N);
                int minI = Math.max(i-R-1, 0);
                int maxI = Math.min(i+R, N);
                int w = sum[maxJ][maxI] - sum[minJ][maxI] - sum[maxJ][minI] + sum[minJ][minI];
                if(i > 1) sb.append(' ');
                sb.append(w);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
