package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        List<String> fileList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            fileList.add(br.readLine());
        }
        //첫 파일이름으로 패턴 초기값 지정 -- 알파벳, ., ?(최소 사용)
        char[] pattern = fileList.get(0).toCharArray();
        //파일이름 공통부분을 제외한 곳에 ? 넣기
        for(int i=0; i<n-1; i++) {
            char[] former = fileList.get(i).toCharArray();
            char[] latter = fileList.get(i+1).toCharArray();
            for(int j=0; j<pattern.length; j++) {
                if(former[j] != latter[j]) {
                    pattern[j] = '?';
                }
            }
        }
        //출력
        for(int j=0; j<pattern.length; j++) {
            bw.write(pattern[j]);
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
