package baekjoon.processing;

import java.io.*;

public class Main1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] n = br.readLine().toCharArray();
        boolean isEugeneNo = false; //유진수 여부 확인용 booelan
        for(int i=1; i<n.length; i++) { //나눌 구간 loop
            int formerSum = 1, latterSum = 1; //앞부분 뒷부분 곱셈 결과값 저장
            for(int j=0; j<i; j++) //앞부분 곱
                formerSum *= Character.getNumericValue(n[j]);
            for(int j=i; j<n.length; j++) //뒷부분 곱
                latterSum *= Character.getNumericValue(n[j]);
            if(formerSum == latterSum) {
                isEugeneNo = true;
                break; //loop 종료
            }
        }
        bw.write(isEugeneNo ? "YES" : "NO");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
