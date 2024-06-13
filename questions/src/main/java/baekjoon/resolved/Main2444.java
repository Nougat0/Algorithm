package baekjoon.resolved;

//import java.io.IOException;
import java.io.*;

public class Main2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1-1,2-3,3-5,4-7 =>
        // 각 줄에는 i*2-1 (~n)
        // 각 줄에는 (n~2*n-1) 2*n-1 -i
        int maxRowNCol = n*2-1;
        br.close();
        // (1,1)0 (1,2)1 (1,3)0 -> 앞뒤로 n-i개씩 없다
        // (2,1)1 (2,2)1 (2,3)1 2
        // (3,1)0 (3,2)1 (3,3)0 3 -> 앞뒤로 (n*2-1) 개씩 없다
        // -> 위아래로 n-i개씩 없다

        for(int i=1; i<=maxRowNCol; i++) {
            for(int j=1; j<=maxRowNCol; j++) {
                // ◆마름모 3등분하여 별 찍기
                if(i<n) { //[1] 위쪽 삼각형
                    if(j > n-i && j <= maxRowNCol - (n-i)) System.out.print("*");
                    else if(j <= n-i) System.out.print(" ");
                    else continue;
                } else if(i==n) { //[2] 가운데 full line
                    System.out.print("*");
                } else if(i>n) { //[3] 아래쪽 역삼각형
                    if(j > i-n && j <= maxRowNCol - (i-n)) System.out.print("*");
                    else if(j <= i-n) System.out.print(" ");
                    else continue;
                }
            }
            System.out.println();
        }
    }
}
