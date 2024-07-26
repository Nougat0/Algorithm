package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1347 {
    static int[][] direction = new int[][] {{1,0}, {0,-1}, {-1,0}, {0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalMove = Integer.parseInt(br.readLine());
        String moves = br.readLine();
        List<List<Boolean>> maze = new ArrayList<>();
        int facing = 0;
        int totalDirection = direction.length;
        int x = 0;
        int y = 0;

        for(int i=0; i<totalMove; i++) {
            char move = moves.charAt(i);
            switch(move) {
                case 'F':
                    switch(facing) {
                        case 0:
                            maze.add(new ArrayList<>());
                            break;
                        case 1:
                            break;
                        case 2:
                            maze.add(new ArrayList<>());
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 'L':
                    facing--;
                    if(facing < 0)
                        facing += totalDirection;
                    break;
                case 'R':
                    facing++;
                    if(facing > totalDirection)
                        facing -= totalDirection;
                    break;

            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
