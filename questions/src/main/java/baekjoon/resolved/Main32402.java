package baekjoon.resolved;

import java.io.*;

public class Main32402 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32402
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Character c = new Character();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            c.action(br.readLine());
        }
        bw.write(c.getLog().toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Character {
        private StringBuilder sb;
        private static final int PER = 0;
        private static final int CAM = 1;
        private static final int X = 0;
        private static final int Y = 1;
        private int[][] pos;
        private int[] dir;
        /**
         * 카메라 방향
         * 0: 위 (위치: 아래쪽)
         * 1: 오른쪽 (위치: 왼쪽)
         * 2: 아래 (위치: 위쪽)
         * 3: 왼쪽 (위치: 오른쪽)
         */
        private int camDirection;

        public Character() {
            pos = new int[][] {{0, 0}, {0, -1}};
            camDirection = 0;
            sb = new StringBuilder();
        }

        void action(String action) {
            char one = action.charAt(0);
            switch(one) {
                case 'M':
                    char two = action.charAt(1);
                    dir = getMove(two);
                    pos[CAM][X] += dir[X];
                    pos[CAM][Y] += dir[Y];
                    if(two == 'R') {
                        camDirection++;
                        if(camDirection > 3) camDirection = 0;
                    } else {
                        camDirection--;
                        if(camDirection < 0) camDirection = 3;
                    }
                    break;
                default:
                    dir = getMove(one);
                    pos[PER][X] += dir[X];
                    pos[PER][Y] += dir[Y];
                    pos[CAM][X] += dir[X];
                    pos[CAM][Y] += dir[Y];
            }
            sb.append(pos[PER][X]).append(' ').append(pos[PER][Y]).append(' ');
            sb.append(pos[CAM][X]).append(' ').append(pos[CAM][Y]).append("\n");
        }

        StringBuilder getLog() {
            return sb;
        }

        private int[] getMove(char action) {
            switch(camDirection) {
                case 0:
                    switch(action) {
                        case 'W': return new int[] {0, 1};
                        case 'A': return new int[] {-1, 0};
                        case 'S': return new int[] {0, -1};
                        case 'D': return new int[] {1, 0};
                        case 'L': return new int[] {1, 1};
                        case 'R': return new int[] {-1, 1};
                    }
                case 1:
                    switch(action) {
                        case 'W': return new int[] {1, 0};
                        case 'A': return new int[] {0, 1};
                        case 'S': return new int[] {-1, 0};
                        case 'D': return new int[] {0, -1};
                        case 'L': return new int[] {1, -1};
                        case 'R': return new int[] {1, 1};
                    }
                case 2:
                    switch(action) {
                        case 'W': return new int[] {0, -1};
                        case 'A': return new int[] {1, 0};
                        case 'S': return new int[] {0, 1};
                        case 'D': return new int[] {-1, 0};
                        case 'L': return new int[] {-1, -1};
                        case 'R': return new int[] {1, -1};
                    }
                case 3:
                    switch(action) {
                        case 'W': return new int[] {-1, 0};
                        case 'A': return new int[] {0, -1};
                        case 'S': return new int[] {1, 0};
                        case 'D': return new int[] {0, 1};
                        case 'L': return new int[] {-1, 1};
                        case 'R': return new int[] {-1, -1};
                    }
                default: return new int[] {0, 0};
            }
        }
    }
}
