package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33781 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33781
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /**
         * 환자에게 진단된 질병을 보고,
         * 해당 질병(들)이 갖고 있는 증상을 모두 수집해서
         * 환자의 현재 증상 (1~s)이 모두 표현되는지 확인하기...
         */
        //total diseases & symptoms count
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); //환자는 1~s 모든 증상을 갖고 있다...
        //patient's diseases (diagnosed)
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        boolean[] diagnosis = new boolean[d+1];
        for(int i=0; i<count; i++) {
            int diseaseCode = Integer.parseInt(st.nextToken());
            diagnosis[diseaseCode] = true;
        }
        //disease & symptoms list
        boolean[] symptoms = new boolean[s+1];
        int symptomCount = 0;
        for(int i=1; i<=d; i++) {
            st = new StringTokenizer(br.readLine());
            if(!diagnosis[i]) continue;
            int p = Integer.parseInt(st.nextToken());
            for(int j=1; j<=p; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(!symptoms[t])  {
                    symptoms[t] = true;
                    symptomCount++;
                }
            }
        }
        boolean isCorrect = symptomCount == s;
        System.out.println(isCorrect ? "yes" : "no");
        br.close();
    }
}
