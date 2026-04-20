package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main2563 {
    /*
        https://www.acmicpc.net/problem/2563
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/source/78666277
        2024.05.22
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][] arr = new boolean[100][100]; //false로 초기화됨
        int paperCnt = Integer.parseInt(br.readLine());
        int x=0, y=0; //왼쪽 아래 꼭지점 명시 (0: 0~1까지의 공간으로 취급)
        int area=0;

        //입력
        for(int i=0; i<paperCnt; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            x = Integer.parseInt(line.nextToken());
            y = Integer.parseInt(line.nextToken());

            for(int j=x; j<(x+10); j++) {
                for(int k=y; k<(y+10); k++) {
                    //if(!arr[j][k]; //if문 매번 하면 너무 느려지지 않을까... 그냥 무조건 set하는 걸로 하기
                    arr[j][k] = true;
                }
            }
        }

        //색종이가 붙은 영역 계산
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(arr[i][j]) area++;
            }
        }

        //출력
        bw.write(String.valueOf(area));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
