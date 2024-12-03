package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arrSize = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[arrSize][arrSize];
        int horizontal = 0, vertical = 0;
        int aligned = 0;
        int[] verticalAlign = new int[arrSize];
        for(int i=0; i<arrSize; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<arrSize; j++) {
                arr[i][j] = line[j] == '.'; //누울 수 있는 공간 = true
                //2칸 연속 체크
                if(arr[i][j]) {
                    aligned++;
                    verticalAlign[j]++;
                } else { //'X' 만나서 연속값 초기화
                    //가로 2칸 확인
                    if(aligned >= 2) horizontal++;
                    aligned = 0;
                    //세로 2칸 확인
                    if(verticalAlign[j] >= 2) vertical++;
                    verticalAlign[j] = 0;
                }
            }
            //한 줄 끝날때마다 2칸 이상 붙어있는지 확인
            if(aligned >= 2) horizontal++;
            aligned = 0;
        }
        //전체 loop 끝나고 세로 2칸 이상 붙어있는지 확인
        for(int i=0; i<arrSize; i++) {
            if(verticalAlign[i] >= 2) vertical++;
        }
        bw.write(horizontal + " " + vertical);
        bw.flush();
        bw.close();
        br.close();
    }
}
