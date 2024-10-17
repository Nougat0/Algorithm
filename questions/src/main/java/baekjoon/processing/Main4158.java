package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String testCase;
        while(!(testCase = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(testCase);
            int sangCDs = Integer.parseInt(st.nextToken());
            int sunCDs = Integer.parseInt(st.nextToken());
            //각자 갖고 있는 CD 번호 입력 및 대조
            int sameCDs = 0;
            List<Integer> listOfCDs = new ArrayList<>();
            for(int i=0; i<sangCDs; i++) listOfCDs.add(Integer.parseInt(br.readLine()));
            for(int i=0; i<sunCDs; i++)
                if(listOfCDs.contains(Integer.parseInt(br.readLine())))
                    sameCDs++; //같이 갖고 있는 CD
            bw.write(sameCDs + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
