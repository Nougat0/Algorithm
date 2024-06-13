package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n][m]; //W: true, B:false
        boolean first = true; //고정
        int minChange = 32; //변동 최대값

        // 보드 정보 읽기
        for(int i=0; i<n; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<m; j++) {
                board[i][j] = line[j] == 'W';
            }
        }

        /**
         * 보드에서 8*8 가능한 범위 검사
         * (1,1) 꼭짓점의 가능한 경우의 수 모두 검사
         */
        for(int i=0; i<=n-8; i++) {
            for(int j=0; j<=m-8; j++) {
                /**
                 * 8*8 1개 검사
                 */
                int change = 64;
                for(int k=i; k<i+8; k++) {
                    for(int l=j; l<j+8; l++) {
                        if((k-i) % 2 == 0) { //홀수 행 검사
                            //first 가 첫 번째
                            if(((l-j) % 2 == 0) && board[k][l] == first) //홀수 열 검사
                                change--;
                            else if(((l-j) % 2 != 0) && board[k][l] != first) //짝수 열 검사
                                change--;
                        } else { //짝수 행 검사
                            //!first 가 첫 번째
                            if(((l-j) % 2 == 0) && board[k][l] != first) //홀수 열 검사
                                change--;
                            else if(((l-j) % 2 != 0) && board[k][l] == first) //짝수 열 검사
                                change--;
                        }

                    }
                }
                //더 작은 값 넣어주기 (칠한 값 OR 반전해서 칠한 값)
                if(change > (64-change)) change = 64-change;
                //최솟값 검사
                if(minChange > change) minChange = change;
            }
        }

        bw.write(minChange+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
