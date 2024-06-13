package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        int m = Integer.parseInt(nm.split(" ")[1]);
        int n = Integer.parseInt(nm.split(" ")[0]);
        int[] basket = new int[n];
        //바구니 번호 채우기
        for(int i=0; i<n; i++) basket[i] = i+1;
        //바구니 배치 변경
        for(int index=0; index<m; index++) {
            String line = br.readLine();
            int i = Integer.parseInt(line.split(" ")[0]);
            int j = Integer.parseInt(line.split(" ")[1]);
            //역순 배치
            for(int idx=i-1; idx<i-1 + (j-i+1)/2; idx++) {
                int temp = basket[idx];
                basket[idx] = basket[i+j-idx-2];
                basket[i+j-idx-2] = temp;
            }
        }
        br.close();
        //출력
        for(int i=0; i<n; i++) System.out.printf("%d ", basket[i]);
        System.out.println();
    }
}
