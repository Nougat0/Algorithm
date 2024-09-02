package baekjoon.processing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1236 {
    public static final char guard = 'X';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //경비원을 추가하되...
        //가로 세로 중첩점에 추가해서 일석이조 효과를 누릴 수 있는 배치로 추가해야 함.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int emptyY = 0;
        int emptyX = 0;

        char[][] castle = new char[y][x];
        for(int i=0; i<y; i++) //성 도면 입력
            castle[i] = br.readLine().toCharArray();

        //가로 세로 빈 곳(경비가 필요한 곳) 확인
        for(int i=0; i<x; i++) {
            boolean guarded = false;
            for(int j=0; j<y; j++)
                if(castle[j][i] == guard) guarded = true;
            if(!guarded) emptyX++;
        }
        for(int i=0; i<y; i++) {
            boolean guarded = false;
            for(int j=0; j<x; j++)
                if(castle[i][j] == guard) guarded = true;
            if(!guarded) emptyY++;
        }
        //X와 Y는 1:1로 중첩 가능(만나는 한 점에 경비원 두기)
        //따라서 emptyX와 emptyY 중 더 큰 수가 작은 수를 흡수한 것으로 볼 수 있다.
        bw.write(Math.max(emptyX, emptyY) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
