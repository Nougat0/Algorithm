package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1388 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행
        int m = Integer.parseInt(st.nextToken()); //열
        boolean[][] checked = new boolean[n][m]; //이미 세아린 타일인지 여부 기록
        char[][] floor = new char[n][m]; //바닥 타일 방향 기록
        //타일 입력
        for(int i=0; i<n; i++) floor[i] = br.readLine().toCharArray();
        //타일 개수 세기
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(checked[i][j]) continue; //이미 세아린 타일
                char tile = floor[i][j]; //이번 타일
                boolean go = true; //계속 이어져있는지 여부
                if(tile == '-') {
                    //가로 검사
                    for(int k=j+1; go && k<m; k++) {
                        go = go && tile == floor[i][k];
                        if(go) checked[i][k] = true;
                    }
                } else {
                    //세로 검사
                    for(int k=i+1; go && k<n; k++) {
                        go = go && tile == floor[k][j];
                        if(go) checked[k][j] = true;
                    }
                }
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
