package baekjoon.resolved;

import java.io.*;

public class Main30434 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30434
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            String line = br.readLine();
            long sum = getSum(line);
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //group별 sum 합산 구하기
    private static long getSum(String line) {
        long sum = 0;
        int base = getValue(line.charAt(line.length()-1));
        int groupSum = base;
        for(int i = line.length()-2; i>=0; i--) {
            int value = getValue(line.charAt(i));
            if(base > value) { //그룹 유지
                groupSum -= value;
            } else { //그룹 초기화
                sum += groupSum;
                base = value;
                groupSum = base;
            }
        }
        sum += groupSum;
        return sum;
    }

    //로마자 <-> 아라비아 환산 함수
    public static int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default: return 1000;
        }
    }
}
