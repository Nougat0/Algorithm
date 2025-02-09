package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main33042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] list = new int[9][4];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력 및 감지
        int noticed = 0;
        for(int i=1; i<=n && noticed == 0; i++) {
            String tile = st.nextToken();
            int number = Character.getNumericValue(tile.charAt(0)) -1;
            char a = tile.charAt(1);
            int index = getIndex(a);

            list[number][index]++;
            if(list[number][index] == 5) { //이변 감지
                noticed = i;
            }
        }
        //출력
        bw.write(noticed + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //마작 패 index 화
    public static int getIndex(char a) {
        switch(a) {
            case 'm': return 0;
            case 'p': return 1;
            case 's': return 2;
            default: return 3;
        }
    }
}
