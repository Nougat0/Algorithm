package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=1; i<=testCase; i++) {
            int standing = 0, needed = 0;
            st = new StringTokenizer(br.readLine());
            int maxIndex = Integer.parseInt(st.nextToken());
            char[] list = st.nextToken().toCharArray();
            for(int shyness=0; shyness<=maxIndex; shyness++) {
                int shynessPeople = list[shyness] - 48;
                int diff = 0;//각 shyness 별로 부족한 기립자 수
                //서 있는 사람이 쑥쓰러움 정도보다 적을 경우
                //추가 필요시 서 있을 사람 추가
                if(standing < shyness) {
                    diff = shyness - standing;
                    needed += diff;
                }
                standing += diff; //부족한 인원 채워넣기
                standing += shynessPeople; //이번 shyness 단계에서 일어날 사람 기립
            }
            sb.append("Case #").append(i).append(": ").append(needed).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
