package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main26043 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/26043
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> line = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int maxNo = 0;
        int[] favMenu = new int[n];
        int[] status = new int[n];
        int[] menuCount = new int[3];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int menu, studentNo;
            //쌓기
            if(type == 1) {
                studentNo = Integer.parseInt(st.nextToken());
                menu = Integer.parseInt(st.nextToken());
                line.add(studentNo);
                favMenu[studentNo] = menu;
                if(maxNo < studentNo) maxNo = studentNo;
            } else {
                menu = Integer.parseInt(st.nextToken());
                menuCount[menu]++;
                //식사
                studentNo = line.poll();
                menu = favMenu[studentNo];
                if(menuCount[menu] > 0) {
                    menuCount[menu]--;
                    status[studentNo] = 1;
                } else {
                    menuCount[3 - menu]--;
                    status[studentNo] = 2;
                }
            }
        }
        int studentNo = 1;
        while(studentNo <= maxNo) {
            // 등장하지 않은 학생번호 예외처리
            if(favMenu[studentNo] == 0) {
                studentNo++;
                continue;
            }
            switch(status[studentNo]) {
                case 1: a.append(studentNo).append(' '); break;
                case 2: b.append(studentNo).append(' '); break;
                default: c.append(studentNo).append(' '); break;
            }
            studentNo++;
        }
        if(a.length() == 0) a.append("None");
        if(b.length() == 0) b.append("None");
        if(c.length() == 0) c.append("None");
        sb.append(a).append("\n").append(b).append("\n").append(c);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
