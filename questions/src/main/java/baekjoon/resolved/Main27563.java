package baekjoon.resolved;

import java.io.*;

public class Main27563 {
    /*
        https://www.acmicpc.net/problem/27563
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;
        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            line = br.readLine();
            int length = line.length();

            if(length < 3) {
                sb.append(-1); //불가능
            } else if(length == 3) {
                sb.append(canBeMoo(line, 0));
            } else { //길이 3이상인 문자열
                //canBeMoo 가 -1이 아닌 구간이 나오면... 해당 구간을 제외한 부분 모두 제거하기?
                //-1이 아닌 구간 중 제일 변환이 적게 필요한 구간을 기억해둬야 할 듯
                //근데 다시보니 굳이 구간을 기억해둬야 하나? move 개수는 똑같을 텐데. 변환만 기억하기
                int leastChange = 3;
                for(int startIndex=0, changes; startIndex<length-3; startIndex++) {
                    changes = canBeMoo(line, startIndex);
                    if(changes > -1 && changes < leastChange) {
                        leastChange = changes;
                    }
                }
                if(leastChange == 3) sb.append(-1); //불가능
                else sb.append(leastChange + (length - 3)); //MOO로 변환할 구간 + 나머지 구간 제거
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 3글자를 MOO로 변환할 수 있는지 확인
     * MOM / OOO 는 1번 가능, OOM은 2번 가능, 가운데가 M인 경우 불가능 (-1)
     * @param line 문자열
     * @param startIndex 3자리의 시작 index
     * @return
     */
    public static int canBeMoo(String line, int startIndex) {
        int moves = 0;
        if(line.charAt(startIndex + 1) == 'M') return -1;
        else {
            if(line.charAt(startIndex) == 'O') moves++;
            if(line.charAt(startIndex + 2) == 'M') moves++;
        }
        return moves;
    }
}
