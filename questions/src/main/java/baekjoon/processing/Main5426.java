package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main5426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            char[] line = br.readLine().toCharArray();
            final int length = (int) Math.sqrt(line.length);
            char[][] letter = new char[length][length];
            //좌표 기준점 변경됨
            /*
            기존 [0][0] -> 시계 반대 방향 90도 회전 시 [length-1][0]
            기존에는 모든 좌표가 0,0 에서부터 뻗어나간 거나 마찬가지였으니
            바뀐 기준점에다 뻗어나가는 방향 조정해주면 원하는 값 가져오기 가능
            */
            final int pointX = 0;
            final int pointY = length-1;
            for(int y=0; y<length; y++) {
                for(int x=0; x<length; x++) {
                    int index = y*length + x;
                    //시계 반대 방향으로 돌리려면 y에 -x를, x에 +y를 더해줘야 함
                    letter[pointY-x][pointX+y] = line[index];
                }
            }
            //메세지 이어붙이기
            for(int y=0; y<length; y++) {
                for(int x=0; x<length; x++) {
                    sb.append(letter[y][x]);
                }
            }
            sb.append("\n");
            /*
            로직 다 완성하고 보니
            그냥 그대로 입력 받아서 오른쪽부터 세로로 출력하면 되는 거잖아!
            너무 어렵게 접근한 느낌 ㅋㅋㅋㅋ
            그래도 기준점 개념 떠올린 건 뿌듯... 언젠가 유의미하게 쓸 수 있겠지
            */
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}