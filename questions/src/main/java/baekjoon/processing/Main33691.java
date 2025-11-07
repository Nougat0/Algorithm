package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main33691 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33691
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder history = new StringBuilder();
        StringBuilder pinHistory = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] logValid = new boolean[n]; //로그 유효여부 순서대로 저장
        String[] containers = new String[n]; //컨테이너 이름 순서대로 저장
        Map<String, Integer> index = new HashMap<>(); //컨테이너 중복 등장 관리
        //로그 기록
        for(int l=n-1; l>=0; l--) {
            String container = br.readLine();
            Integer prevIndex = index.put(container, l);
            logValid[l] = true; //l번째 로그 유효여부 기록
            containers[l] = container; //l번째 로그 컨테이너 기록

            if(prevIndex != null) { //이전 로그 유효하지 않음 처리
                logValid[prevIndex] = false;
            }
        }
        //즐겨찾기 (북마크) 기록
        int k = Integer.parseInt(br.readLine());
        String[] pinned = new String[k]; //역순 표시를 위한 기록
        for(int p=k-1; p>=0; p--) {
            String pin = br.readLine();
            Integer prevIndex = index.get(pin);
            pinned[p] = pin;

            if(prevIndex != null) {  //이전 로그 유효하지 않음 처리
                logValid[prevIndex] = false;
            }
        }
        //기록 출력
        for(int i=0; i<n; i++) {
            if(logValid[i]) history.append(containers[i]).append("\n");
            if(i < k) pinHistory.append(pinned[i]).append("\n");
        }
        bw.write(pinHistory.toString()); //즐겨찾기 먼저 출력
        bw.write(history.toString()); //방문기록 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
