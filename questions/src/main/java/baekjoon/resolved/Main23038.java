package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main23038 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/23038
    */
    private static final int TOP = 1;
    private static final int LEFT = 2;
    private static final int BOTTOM = 4;
    private static final int RIGHT = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] grid = new boolean[3*n][3*m];
        int[][] shape = new int[n][m];
        //각 칸마다... 4방향에 대한 정보가 있어야 하는데
        //방향에 대한 값을 각각 1234 라고 한다면
        //어떤 값이 빠졌는지 알 수 있지 않을까?
        //아... 3이 빠졌는데 12가 빠졌다고 생각할 수도 있겠구나
        //일단 3차원 배열을 쓴다는 것은 말도 안되고
        //1357 해봤는데 안됨
        //서로가 서로를 구현할 수 없음 + 작은 값을 더해서 큰 값을 뛰어넘을 수 없어야 함
        //최소 정수로는 1 2 4 8

        //입력
        for(int i=0; i<3*n; i++) {
            char[] c = br.readLine().toCharArray();
            for(int j=0; j<3*m; j++) {
                grid[i][j] = c[j] == '#';
            }
        }
        //n*m 칸 각각에 대해 뻗은 방향을 숫자로 치환
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                //현재의 3*3 공간 확인
                int sum = 0;
                if(grid[3*i][3*j+1]) sum += TOP;
                if(grid[3*i+1][3*j]) sum += LEFT;
                if(grid[3*i+2][3*j+1]) sum += BOTTOM;
                if(grid[3*i+1][3*j+2]) sum += RIGHT;
                shape[i][j] = sum;
            }
        }

        //인접 4칸의 모양으로 현재 모양 유추
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                //홀수 칸에서만 진행
                if((i+j) % 2 == 0) continue;

                boolean hasTop = false;
                boolean hasBottom = false;
                boolean hasLeft = false;
                boolean hasRight = false;

                int count = 0;
                if(i>0 && checkShape(shape[i-1][j], BOTTOM)) {
                    hasTop = true;
                    count++;
                }
                if(j>0 && checkShape(shape[i][j-1], RIGHT)) {
                    hasLeft = true;
                    count++;
                }
                if(i<n-1 && checkShape(shape[i+1][j], TOP)) {
                    hasBottom = true;
                    count++;
                }
                if(j<m-1 && checkShape(shape[i][j+1], LEFT)) {
                    hasRight = true;
                    count++;
                }

                if(count > 1) grid[3*i+1][3*j+1] = true;
                if(hasTop) grid[3*i][3*j+1] = true;
                if(hasLeft) grid[3*i+1][3*j] = true;
                if(hasBottom) grid[3*i+2][3*j+1] = true;
                if(hasRight) grid[3*i+1][3*j+2] = true;
            }
        }

        //출력하기
        for(int i=0; i<3*n; i++) {
            for(int j=0; j<3*m; j++) {
                sb.append(grid[i][j] ? '#' : '.');
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkShape(int shape, int pos) {
        //    top
        //left   right
        //   bottom
        boolean right = shape / RIGHT == 1;
        if(right) shape -= RIGHT;
        boolean bottom = shape / BOTTOM == 1;
        if(bottom) shape -= BOTTOM;
        boolean left = shape / LEFT == 1;
        if(left) shape -= LEFT;
        boolean top = shape == TOP;

        switch(pos) {
            case TOP: return top;
            case BOTTOM: return bottom;
            case LEFT: return left;
            default: return right;
        }
    }
}


