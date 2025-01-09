package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main19740 {
    /*
    소실된 파일들 사이에서
    존재했을 수 있는 파일의 숫자 최소값과 최대값 구하기
    (숫자는 1~N 까지 연속되게 존재함)
    파일 이름 길이는 최소값을 사용한다고 했으니 예시로
    길이 4 -> 1000 이 최소값의 최소값 (더 큰 4자리수 나오면 그게 최소값)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int maxFileNo = 1, length = 0; //파일 최소번호, 파일명 길이
        int existing = Integer.parseInt(br.readLine()); //남아있는 파일의 수
        for(int i=0; i<existing; i++) {
            String fileName = br.readLine(); //파일명
            int n = Integer.parseInt(fileName); //테스트 번호
            if(n > maxFileNo) maxFileNo = n;
            if(length == 0) length = fileName.length();
        }
        sb.append(Math.max(maxFileNo, pow(10, (length-1)))).append("\n"); //최소값
        sb.append("9".repeat(length)).append("\n"); //최대값
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * N제곱수 구하기
     * @param number N제곱할 수
     * @param power N
     * @return N제곱수
     */
    static int pow(int number, int power) {
        int result = 1;
        for(int i=0; i<power; i++) {
            result *= number;
        }
        return result;
    }
}
