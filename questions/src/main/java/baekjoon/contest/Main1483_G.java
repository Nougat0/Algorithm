package baekjoon.contest;

import java.io.*;

public class Main1483_G {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1483/7
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        Bracket bracket;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] line = br.readLine().toCharArray();
            bracket = new Bracket(line);
            bracket.makeValid();
            sb.append(bracket.swapCount).append("\n");
            if(bracket.swapCount > 0) sb.append(bracket.sb);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Bracket {
        char[] line;
        boolean valid;
        //Invalid 범위 전역변수로 추적
        int startIndex;
        int endIndex;
        int swapCount;
        StringBuilder sb;

        public Bracket(char[] line) {
            this.line = line;
            this.valid = false;
            this.startIndex = 0;
            this.endIndex = line.length-1;
            this.sb = new StringBuilder();
        }

        /**
         * 유효하지 않은 괄호문자열 유효하게 만들기
         */
        public void makeValid() {
            while(!checkInvalid()) {
                swap();
                //index 0~N-1 -> 1~N 보정
                sb.append(startIndex+1).append(' ').append(endIndex+1).append("\n");
            }
        }

        /**
         * 유효한 문자열인지 체크
         * @return
         */
        public boolean checkInvalid() {
            int length = endIndex - startIndex + 1;
            int frontOpened = 0, backOpened = 0; //0이하로 내려갈 일이 없어야 valid
            int frontIndex = startIndex;
            int backIndex = endIndex;
            for(int index=0; index<length && !(frontOpened<0 && backOpened<0); index++) {
                //각자 앞/뒤에서부터 유효한지 검사
                if(frontOpened >=0) {
                    if(line[startIndex + index] == '(') frontOpened++;
                    else if(line[startIndex + index] == ')') frontOpened--; //closed 와 같다
                    frontIndex++;
                }
                if(backOpened >= 0) {
                    if(line[endIndex - index] == ')') backOpened++;
                    else if(line[endIndex - index] == '(') backOpened--; //closed 와 같다
                    backIndex--;
                }
            }
            //결과 전역변수에 저장
            if(frontOpened != 0 && backOpened != 0) {
                valid = false;
                endIndex = backIndex + 1; //멈춘시점 보정
                startIndex = frontIndex - 1; //멈춘시점 보정
            } else {
                valid = true;
            }
            return valid;
        }

        /**
         * 부분문자열 뒤집기
         */
        public void swap() {
            int loop = (endIndex - startIndex + 1)/2;
            char temp;
            for(int i=0; i<loop; i++) {
                temp = line[startIndex+i];
                line[startIndex+i] = line[endIndex-i];
                line[endIndex-i] = temp;
            }
            swapCount++;
        }
    }
}
