package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32627 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32627
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        boolean[] sErase = new boolean[n]; //문자열 S의 각 자리 지움여부

        int a; //알파벳
        int aMin = 26; //알파벳 탐색범위 최소값 관리
        int[] aCount = new int[26]; //알파벳별 사용횟수
        Queue<Integer>[] aPos = new LinkedList[26]; //알파벳별 위치

        for(int i=0; i<n; i++) {
            a = s.charAt(i) - 'a';
            aCount[a]++;

            if(aMin > a) aMin = a;

            if(aPos[a] == null) {
                Queue<Integer> que = new LinkedList<>();
                que.add(i);
                aPos[a] = que;
            } else {
                aPos[a].add(i);
            }
        }
        // m회 지우기
        for(int i=0; i<m; i++) {
            a = getSmallest(aCount, aMin);
            aMin = a; //최소값 갱신
            sErase[aPos[a].poll()] = true;
            aCount[a]--;
        }
        // 문자열 출력
        for(int i=0; i<n; i++) {
            if(!sErase[i]) sb.append(s.charAt(i));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getSmallest(int[] used, int start) {
        for(int i=start; i<26; i++) {
            if(used[i] > 0) return i;
        }
        return -1; //문제 조건상 이 부분은 사용되지 않음
    }
}
