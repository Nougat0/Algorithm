package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1463 {
    /*
    작은 수 최소값부터 구해야 큰 수 ~ n 의 최소값을 구할 수 있으므로
    강제 Bottom-Up 방식인 것 같다 (깔끔한 방식으로 가자니까 그렇다)
    소인수분해를 통해 약수를 구하고, full scan을 피해갈 수 있지 않나?란 생각이 잠깐 들었지만
    그렇게 접근한다고 해도... 그게 연산 횟수 최소값인지는 알 수 없으므로 무용지물이다
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] minCount = new int[1000001]; // index = 0(미사용) ~ n
        //DP :: Bottom-Up 방식
        for(int i=2; i<=n; i++) {
            //세 가지 방식 놓고 어느 것이 최소값인지 밑의 수 최소값으로 비교
            boolean mod3OK = i % 3 == 0;
            boolean mod2OK = i % 2 == 0;
            //boolean minus1OK = true; //항상 가능
            int mod3 = mod3OK ? minCount[i/3] : n;
            int mod2 = mod2OK ? minCount[i/2] : n;
            int minus1 = minCount[i-1];
            //이번 연산으로 +1
            minCount[i] = Math.min(mod3, Math.min(mod2, minus1)) + 1;
        }

        bw.write(minCount[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
