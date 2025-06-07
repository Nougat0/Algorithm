package baekjoon.resolved;

import java.io.*;

public class Main14626 {
    /*
        https://www.acmicpc.net/problem/14626
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int ISBN_LENGTH = 13;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        boolean isTriple = false;
        int sum = 0;
        //합산 구하기
        for(int i=0; i<ISBN_LENGTH-1; i++) {
            char c = line.charAt(i);
            if(c == '*') {
                isTriple = i % 2 == 1;
            } else {
                int number = Character.getNumericValue(c);
                sum += number * (i % 2 == 1 ? 3 : 1);
            }
        }
        //(체크기호 mod 10) + (합산 mod 10) = 10
        int checkNumber = Character.getNumericValue(line.charAt(ISBN_LENGTH-1));
        int neededModValue = (10 - (checkNumber % 10)) % 10;
        //'*' 값 브루트 포스로 찾기
        for(int i=0; i<10; i++) {
            if((sum + (isTriple ? 3 : 1) * i) % 10 == neededModValue) {
                bw.write(i + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
