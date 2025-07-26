package baekjoon.processing;

import java.io.*;

public class Main1193 {
    /*
        https://www.acmicpc.net/problem/1193
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int addTurns = 1; //다음번 추가할 개수
        int totalTurn = 0; //지금까지 추가된 개수

        while((totalTurn + addTurns) < x) {
            totalTurn += addTurns++; //다음 줄 세팅
        }
        boolean isForward = addTurns % 2 == 1; //짝수번째에 역순
        int posFromLeft = isForward ? (x - totalTurn) : addTurns - (x - totalTurn) + 1;

        //numor: 분수, denom: 분모
        int numor = addTurns - posFromLeft + 1;
        int denom = posFromLeft;

        bw.write(numor + "/" + denom);
        bw.flush();
        bw.close();
        br.close();
    }
}
