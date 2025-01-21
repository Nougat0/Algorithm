package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //초기화
        int danceCnt = 1; //최초 춤추는 사람(토끼): 총총이 1명
        Set<String> danceList = new HashSet<>(); //춤추는 사람 목록
        danceList.add("ChongChong");
        //입력
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();
            boolean dancing1 = danceList.contains(person1);
            boolean dancing2 = danceList.contains(person2);
            //앞사람이나 뒷사람이 춤을 추고 있는지 확인
            if(dancing1 ^ dancing2) {
                //한 명만 춤추고 있다면 둘 다 춤추게 만들기
                if(dancing1) danceList.add(person2);
                else if(dancing2) danceList.add(person1);
                danceCnt++;
            }
        }
        //출력
        bw.write(danceCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
