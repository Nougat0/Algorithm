package baekjoon.resolved;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main9506 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9506
        https://www.acmicpc.net/source/79023496
        2024.05.30
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean hasNext = true;
        while(hasNext) {
            int n  = Integer.parseInt(br.readLine());
            List<Integer> divisor = new ArrayList<>();

            if(n == -1) { //입력 끝 감지
                hasNext = false;
            } else {
                //약수 확인, 합 확인
                int sum = 0;
                for(int i=1; i<n; i++) {
                    if(n % i == 0) {
                        divisor.add(i);
                        sum += i;
                    }
                }
                //완전수일 경우, 아닐 경우 출력
                if(sum == n)
                    bw.write(String.format("%d = ", n) + divisor.stream().map(Object::toString).collect(Collectors.joining(" + ")) + "\n");
                else
                    bw.write(String.format("%d is NOT perfect.%n", n));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
