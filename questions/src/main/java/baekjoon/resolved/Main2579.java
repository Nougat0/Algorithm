package baekjoon.resolved;

import java.io.*;

public class Main2579 {
    /*
        https://www.acmicpc.net/problem/2579
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int[] values = new int[n+1]; //중간 경우의 수 연산용
        int[] maxValues = new int[n+1]; //최대값 저장
        //미리 연산
        values[1] = Integer.parseInt(br.readLine());
        maxValues[1] = values[1];
        //(n > 1)일 경우 추가 연산
        if(n > 1) {
            values[2] = Integer.parseInt(br.readLine());
            maxValues[2] = maxValues[1] + values[2];
            /*최대값 찾기 (X: 이번값, V: 값, M: 최대값)

                1) ...   M_X
                2) ...  M_VX

                X (이번값)은 마지막 계단으로서 항상 밟음
                이에 따라 X 앞에도 밟는지, 한 칸 건너뛰고 밟는지만 확인하면 됨

                maxValue 값은 항상 뒤가 막혀 있음 (마지막 계단은 항상 밟음)
                따라서 maxValue 앞에 한 칸을 띄워서 확인해도 됨

                결국 선택된 계단 시퀀스는 위의 2가지 경우 중 하나로 반복해서 이어지게 된다
                2)을 풀어서 보면 M_VX -> [M_VV]_VX 이거나 [M_V]_VX 이거나
                1)을 풀어서 보면 M_X  -> [M_VV]_X 이거나 [M_V]_X 이거나

                직접 생각하면서 풀다가 4가지 경우로 너무 복잡하게 생각하고도 틀려서...
                질문게시판 글을 보고 로직 수정함...
                https://www.acmicpc.net/board/view/159591
            */
            for(int i=3; i<=n; i++) {
                values[i] = Integer.parseInt(br.readLine());
                maxValues[i] = Math.max(maxValues[i-2], maxValues[i-3] + values[i-1]) + values[i];
            }
        }
        System.out.println(maxValues[n]);
        br.close();
    }
}
