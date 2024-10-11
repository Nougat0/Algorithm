package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main11723 {
    public static final String add = "add";
    public static final String remove = "remove";
    public static final String check = "check";
    public static final String toggle = "toggle";
    public static final String all = "all";
    public static final String empty = "empty";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int calculation = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st;
        for(int i=0; i<calculation; i++) { //연산 개수 M
            int x = 0;
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(st.hasMoreTokens()) //all, empty 연산에서는 동작하지 않음
                x = Integer.parseInt(st.nextToken());
            switch(command) { //연산
                case add: //추가
                    set.add(x);
                    break;
                case remove: //제거
                    set.remove(x);
                    break;
                case check: //존재 확인
                    if(set.contains(x)) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case toggle: //있으면 제거, 없으면 추가
                    if(set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case all: //1~20까지 모두 추가
                    for(int s=1; s<=20; s++) set.add(s);
                    break;
                case empty: //모두 제거
                    set.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
