package programmers.resolved;

import java.io.*;
import java.util.*;

public class Solution389478 {
    /*
        https://school.programmers.co.kr/learn/courses/30/lessons/389478
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        System.out.println(solution(n, w, num));
    }
    /**
     * n: 총 상자의 개수
     * w: 너비
     * num: 꺼낼 상자의 번호
     */
    public static int solution(int n, int w, int num) {
        int answer = 0;
        int[][] pile = pileUp(n, w);
        int[] pos = getPos(w, num-1);

        int row = pos[0];
        while(row < pile.length) {
            if(pile[row][pos[1]] > 0) answer++;
            row++;
        }
        return answer;
    }

    private static int[][] pileUp(int n, int cols) {
        int rows = n/cols + (n%cols > 0 ? 1 : 0);
        int[][] pile = new int[rows][cols];

        for(int i=0; i<n; i++) {
            int[] p = getPos(cols, i);
            pile[p[0]][p[1]] = i+1;
        }
        return pile;
    }

    private static int[] getPos(int cols, int index) {
        int row = index/cols;
        int col = index%cols;
        boolean goRight = row%2 == 0;
        return new int[] {row, goRight ? col : (cols - 1 - col)};
    }
}
