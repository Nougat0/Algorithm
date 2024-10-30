package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력
        int number = Integer.parseInt(st.nextToken());
        int maxLength = Integer.parseInt(st.nextToken());
        //연산
        StringBuilder sb = new StringBuilder(maxLength);
        for(int i=0; i<number && sb.length()<maxLength; i++)
            sb.append(number);
        if(sb.length() > maxLength) //문자열 길이 최대값 넘었을 경우에만 길이 지정
            sb.setLength(maxLength); //StringBuilder.setLength(length) -> length보다 짧은 문자열의 경우 빈칸으로 채움
        //출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
