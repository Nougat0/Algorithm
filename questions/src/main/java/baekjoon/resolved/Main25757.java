package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Set<String> applied = new HashSet<>();
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int needed = Game.getQuota(st.nextToken()) - 1; //본인 제외 필요인원
        for(int i=0; i<n; i++) {
            applied.add(br.readLine());
        }
        //출력 - 아뿔싸 HashSet 썼으면서 왜 활용 10%밖에 못했었니... 활용도 100% 코드로 변경
        bw.write(applied.size() / needed + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 게임별 모집정원 표기용 enum 정의
     */
    enum Game {
        Y, F, O; //각 게임 약어 목록 (모집정원 순서대로 정렬됨)
        static int getQuota(String game) {
            return Game.valueOf(game).ordinal() + 2;
        }
    }
}
