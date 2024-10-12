package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main22950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int digits = Integer.parseInt(br.readLine());
        char[] number = br.readLine().toCharArray();
        int k = Integer.parseInt(br.readLine()); //2^k는 10^k 형태와 같다
        //연산
        boolean hasRemains = false; //나머지 존재여부
        for(int i=1; i<=k; i++) //뒤에서 k개 자릿수에 1이 존재 시 나머지가 됨.
            if(digits-i >= 0 && number[digits-i] == '1') {
                hasRemains = true;
                break;
            }
        //출력
        bw.write(hasRemains ? "NO" : "YES");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
