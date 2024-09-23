package baekjoon.processing;

import java.io.*;

public class Main1668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int totalTrophyCnt = Integer.parseInt(br.readLine());
        int[] trophyShelf = new int[totalTrophyCnt];
        for(int i=0; i<totalTrophyCnt; i++) trophyShelf[i] = Integer.parseInt(br.readLine());
        /*
            범위 내 가장 큰 사이즈 찾기
            -> 가장 큰 사이즈의 방향순 첫 번째 위치 찾기
            -> 해당 위치로 범위 재설정
        */
        /** 왼쪽에서 보기 **/
        int iSpyTrophy = 0;
        int fromIdx = 0;
        int toIdx = totalTrophyCnt-1;
        while(toIdx >= fromIdx) {
            int biggestSize = findBiggestSize(trophyShelf, Math.min(fromIdx, toIdx), Math.max(fromIdx, toIdx));
            for(int i=fromIdx; i<=toIdx; i++)
                if(trophyShelf[i] == biggestSize) {
                    toIdx = i-1;
                    iSpyTrophy++;
                    break;
                }
        }
        bw.write(iSpyTrophy + "\n");

        /** 오른쪽에서 보기**/
        iSpyTrophy = 0;
        fromIdx = totalTrophyCnt-1;
        toIdx = 0;
        while(toIdx <= fromIdx) {
            int biggestSize = findBiggestSize(trophyShelf, Math.min(fromIdx, toIdx), Math.max(fromIdx, toIdx));
            for(int i=fromIdx; i>=toIdx; i--)
                if(trophyShelf[i] == biggestSize) {
                    toIdx = i+1;
                    iSpyTrophy++;
                    break;
                }
        }
        bw.write(iSpyTrophy + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 주어진 범위 내에서 가장 큰 트로피의 크기를 찾는다
     * @param trophyShelf 트로피 진열장 배열
     * @param fromIdx 부터 찾기
     * @param toIdx 까지 찾기
     * @return 가장 큰 트로피의 크기
     */
    public static int findBiggestSize(int[] trophyShelf, int fromIdx, int toIdx) {
        int biggestSize = -1;
        for(int i=fromIdx; i<=toIdx; i++)
            if(trophyShelf[i] > biggestSize)
                biggestSize = trophyShelf[i];
        return biggestSize;
    }
}
