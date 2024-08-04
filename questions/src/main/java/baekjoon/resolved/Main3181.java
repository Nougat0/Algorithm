package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3181 {
    //무시할 단어 목록
    static String[] blockList = new String[] {"i", "pa", "te","ni","niti","a","ali","nego", "no", "ili"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append(st.nextToken().charAt(0)); //첫 단어는 무사통과

        while(st.hasMoreTokens()) { //문장의 2번째 단어부터
            String word = st.nextToken();
            //무시할 단어에 해당되는지 확인 및 출력
            boolean freeToGo = true;
            for(int i=0; i<blockList.length; i++)
                if(blockList[i].equals(word)) {
                    freeToGo = false;
                    break;
                }
            if(freeToGo) sb.append(word.charAt(0));
        }
        //대문자로 출력
        bw.write(sb.toString().toUpperCase() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

