package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main26069 {
    public static final String Chong = "ChongChong";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] meet;
        boolean infectionStart = false; //춤 바이러스 감염 시작여부
        int danceCnt = 1; //최초 춤추는 사람(토끼): 총총이 1명
        Map<String, Boolean> danceList = new HashMap<>(); //춤추는 사람 목록
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            meet = new String[] {st.nextToken(), st.nextToken()};
            //총총이를 만났는지 여부 확인
            if(!infectionStart) {
                infectionStart = (meet[0].charAt(0) == 'C' && meet[0].equals(Chong) || meet[1].charAt(0) == 'C' && meet[1].equals(Chong));
                if(infectionStart) {
                    //총총이를 만났으므로 춤추는 목록에 추가
                    for(int j=0; j<2; j++) {
                        danceList.put(meet[j], true);
                    }
                    danceCnt++;
                }
            } else {
                int dancing = 0;
                //앞사람이나 뒷사람이 춤을 추고 있는지 확인
                for(int j=0; j<2; j++) {
                    if(danceList.containsKey(meet[j])) {
                        dancing++;
                    }
                }
                //한 명만 춤추고 있다면 둘 다 춤추게 만들기
                if(dancing == 1) {
                    for(int j=0; j<2; j++) {
                        danceList.put(meet[j], true);
                    }
                    danceCnt++;
                }
            }
        }
        bw.write(danceCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
