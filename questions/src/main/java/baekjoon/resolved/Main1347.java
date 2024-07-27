package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1347 {
    static int totalDirection = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalMove = Integer.parseInt(br.readLine());
        String moves = br.readLine();
        List<String> maze = new ArrayList<>(){{add(".");}};
        int facing = 0; //방향
        int xLength = 1, yLength = 1; //미로의 크기
        int x = 0, y = 0; //현재 홍준의 위치

        //입력받은 움직임 그대로 따라가기
        for(int i=0; i<totalMove; i++) {
            char move = moves.charAt(i); //각 움직임 실행
            switch(move) {
                case 'F': //전진
                    //시계방향으로 방향 가정 (0:아래, 1:오른쪽, 2:위, 3:왼쪽)
                    switch(facing) {
                        case 0: //아래
                            y++;
                            if(y > maze.size()-1) { //새 줄 추가일 경우
                                //현재 x 자리만 . 으로 표시하고 나머지는 #으로 채워야 함
                                String line = "#".repeat(x) + "." + "#".repeat(xLength-x-1);
                                maze.add(y, line);
                                yLength++;
                            } else { //이미 줄이 있을 경우
                                String line = maze.get(y);
                                line = line.substring(0, x) + "." + line.substring(x + 1, xLength);
                                maze.set(y, line);
                            }
                            break;
                        case 1: //왼쪽
                            x--;
                            if(x < 0) { //새 칸 추가일 경우
                                for(int j=0; j<yLength; j++)
                                    if(j == y) maze.set(j, "." + maze.get(j));
                                    else maze.set(j, "#" + maze.get(j));
                                xLength++;
                                x = 0;
                            } else {
                                String line = maze.get(y);
                                line = line.substring(0, x) + "." + line.substring(x+1, xLength);
                                maze.set(y, line);
                            }
                            break;
                        case 2: //위
                            y--;
                            if(y < 0) { //새 줄 추가일 경우
                                y = 0;
                                String line = "#".repeat(x) + "." + "#".repeat(xLength-x-1);
                                maze.add(y, line);
                                yLength++;
                            } else {
                                String line = maze.get(y);
                                line = line.substring(0, x) + "." + line.substring(x+1, xLength);
                                maze.set(y, line);
                            }
                            break;
                        case 3: //오른쪽
                            x++;
                            if(x > xLength-1) { //새 칸 추가일 경우
                                for(int j=0; j<yLength; j++)
                                    if(j == y) maze.set(y, maze.get(y) + ".");
                                    else maze.set(j, maze.get(j) + "#");
                                xLength++;
                            } else {
                                String line = maze.get(y);
                                line = line.substring(0, x) + "." + line.substring(x+1, xLength);
                                maze.set(y, line);
                            }
                            break;
                    }
                    break;
                case 'L': //좌회전
                    facing--;
                    if(facing < 0)
                        facing += totalDirection;
                    break;
                case 'R': //우회전
                    facing++;
                    if(facing >= totalDirection)
                        facing -= totalDirection;
                    break;
            }
        }
        //출력
        for(String line: maze) {
            bw.write(line + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
