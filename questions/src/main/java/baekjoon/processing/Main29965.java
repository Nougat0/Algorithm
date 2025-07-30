package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main29965 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/29965
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int maryCount = 0;
        double marySum = 0;
        int juryCount = 0;
        double jurySum = 0;
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken().charAt(0)) {
                case 'M':
                    maryCount++;
                    marySum += Integer.parseInt(st.nextToken());
                    break;
                default:
                    juryCount++;
                    jurySum += Integer.parseInt(st.nextToken());
            }
        }
        int maryToJury = Double.compare(marySum/maryCount, jurySum/juryCount);
        if(maryToJury > 0) System.out.println("M");
        else if(maryToJury < 0) System.out.println("J");
        else System.out.println("V");
        br.close();
    }
}
