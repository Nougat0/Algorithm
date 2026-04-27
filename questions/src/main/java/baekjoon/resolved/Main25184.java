package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        /*
            n개의 항목들 모두가 1 이상 n 이하의 값이어야 하고... 서로 달라야 하고...
            이웃한 항목의 차이는 n/2 이상이어야 하고...

            결국 1~n을 인접한 항목끼리의 차를 유지하면서 배치하면 된다...
            in: 5000 일 때, 서로간의 차는 2500 이상 (홀수라도 └ ┚ 기호에 둘러싸여서 내림한 값 쓰면 됨)
            1~5000을 반으로 쪼개면 1~2500 / 2501~5000이고
            그러면 예제가 사용한 방식대로 2500 5000 2499 4999 ... 이렇게 하면 되나?
            차이: (2500) (2501) (2500) ... 될 듯?

            홀수일 때만 잠깐 보고 가자
            in: 7 일 때, 1 2 3 4 5 6 7 (최소 차이: 3)
            가운데 숫자부터 시작해서 내려가야 할 듯
            4 7 3 6 2 5 1
            짝수랑 같은데, 마지막에 1 수동으로 붙여주기
        */
        boolean isOdd = n%2 == 1;
        int left = n/2 + (isOdd ? 1 : 0);
        int right = n;
        for(int i=0; i<n/2; i++) {
            sb.append(left - i).append(' ').append(right - i).append(' ');
        }
        if(isOdd) sb.append(1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
