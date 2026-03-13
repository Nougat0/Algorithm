package baekjoon.processing;

import java.io.*;

public class Main12043 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/12043
    */
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=t; testCase++) {
            char[] line = br.readLine().toCharArray();
            int length = line.length;
            int[] count = new int[4]; //[x,1,2,3]

            sb.append("Case #").append(testCase).append(": ");
            if(length == 1) {
                sb.append(1).append("\n");
                continue;
            }

            //일반 경우 처리 (길이 2 초과 - 가운데)
            for(int i=1; i<length-1; i++) {
                char a = line[i-1];
                char b = line[i];
                char c = line[i+1];
                int unique = getDiffCount(a, b, c);
                count[unique]++;
            }
            //edge case 처리 (길이 2 이상 - 양끝)
            int[] edgeCase = {0, line.length-1};
            for(int i : edgeCase) {
                char a = line[i];
                char b = line[i == 0 ? i+1 : i-1];
                int unique = getDiffCount(a, b, '#') - 1;
                count[unique]++;
            }

            long result = 1;
            for(int base=2; base<=3; base++) {
                int exp = count[base];
                if(exp > 0) {
                    result = result * power(exp, base) % MOD;
                }
            }
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 서로 다른 개수 구하기
    private static int getDiffCount(char a, char b, char c) {
        if(a == b && a == c) return 1;
        else if(a == b || a == c || b == c) return 2;
        else return 3;
    }

    /**
     * 분할 정복을 이용한 거듭제곱
     * @param base
     * @param exp
     * @return
     */
    private static long power(long base, long exp) {
        if(exp == 0) return 1;
        long temp = power(base, exp/2);

        long result = (temp * temp) % MOD;
        if(exp % 2 == 1) {
            result = (result * (base % MOD)) % MOD;
        }
        return result;
    }
}
