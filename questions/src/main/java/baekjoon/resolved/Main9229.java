package baekjoon.resolved;

import java.io.*;

public class Main9229 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9229
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        while(!(input = br.readLine()).equals("#")) {
            //테스트케이스 셋팅
            String base = input; //첫 줄
            boolean isLadder = true;
            //테스트케이스 확인
            while(!(input = br.readLine()).equals("#")) {
                isLadder &= isLadder(base, input);
                base = input; //기준점 갱신
            }
            //테스트케이스 결과 부착
            sb.append(isLadder ? "Correct" : "Incorrect").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 단어끼리 문자 하나 차이나는 Ladder인지 확인
     * @param base //직전 문자열
     * @param input //이번 문자열
     * @return
     */
    public static boolean isLadder(String base, String input) {
        int changed = 0;
        int baseLength = base.length();
        int inputLength = input.length();
        if(baseLength != inputLength) return false;
        for(int i=0; i<baseLength; i++)
            if(base.charAt(i) != input.charAt(i))
                changed++;
        return changed == 1;
    }
}
