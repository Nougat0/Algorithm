package baekjoon.resolved;

import java.io.*;

public class Main4396 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4396
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        //지뢰 정보 입력
        for(int row=0; row<N; row++) {
            String line = br.readLine();
            for(int col=0; col<N; col++) {
                boolean isMine = line.charAt(col) == '*';
                if(isMine) {
                    map[row][col] = 9; //입력값(0~8) 초과값 9로 초기화
                    //주위 8칸, 현재 칸 +1
                    for(int i=-1; i<=1; i++) {
                        for(int j=-1; j<=1; j++) {
                            try {
                                map[row+i][col+j]++;
                            } catch (ArrayIndexOutOfBoundsException e) {}
                        }
                    }
                }
            }
        }
        //열린칸 확인 및 지뢰 확인
        boolean caboom = false;
        for(int row=0; row<N; row++) {
            String line = br.readLine();
            for(int col=0; col<N; col++) {
                boolean isOpen = line.charAt(col) == 'x';
                boolean isMine = map[row][col] >= 9;
                if(isMine) { //지뢰 칸
                    if(isOpen) caboom = true;
                } else if(!isOpen) { //일반 칸
                    map[row][col] = -1;
                }
            }
        }
        //지뢰가 터졌는지 확인 후 출력
        for(int row=0; row<N; row++) {
            for(int col=0; col<N; col++) {
                boolean isMine = map[row][col] >= 9;
                boolean isBlank = map[row][col] == -1;
                if(caboom && isMine) {
                    sb.append('*');
                } else if(isMine || isBlank) {
                    sb.append('.');
                } else {
                    sb.append(map[row][col]);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
