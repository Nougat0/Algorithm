package baekjoon.processing;

import java.io.*;

public class Main5177 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5544
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int K = Integer.parseInt(br.readLine());
        char[][] format = new char[2][1000];
        int formatIndex = 0;
        for(int k=1; k<=K; k++) {
            if(k < K) sb.append("\n");
            sb.append("Data Set ").append(k).append(": ");
            //2줄 loop
            for(int loop=0; loop<2; loop++) {
                String line = br.readLine();
                int lineLength = line.length();
                int lastIndex = lineLength - 1;
                int lineIndex = 0;
                //맨앞 공백 제거
                while(line.charAt(lineIndex) == ' ') {
                    lineIndex++;
                }
                //맨뒤 공백 제거
                while(line.charAt(lastIndex) == ' ') {
                    lastIndex--;
                }
                //중간 패턴 기록
                int index;
                for(index=lineIndex, formatIndex=0; index<=lastIndex; index++) {
                    //2칸 이상의 공백 존재 시 index 조정
                    index = deleteWhiteSpace(line, index);
                    //출력형식 문자 통일
                    char c = unify(line.charAt(index));
                    if(isSymbol(c) && index > 0 && format[loop][formatIndex-1] != ' ') {
                        //이전 패턴 문자열이 공백 아니면 추가
                        format[loop][formatIndex] = ' ';
                        format[loop][formatIndex+1] = c;
                        formatIndex++;
                    } else {
                        format[loop][formatIndex] = c;
                    }
                    formatIndex++;
                }
            }
            //패턴 비교
            boolean isEqual = true;
            for(int i=0; i<=formatIndex && isEqual; i++) {
                if(format[0][i] != format[1][i]) isEqual = false;
            }
            sb.append(isEqual ? "equal" : "not equal").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 같은 것으로 취급되는 문자들 통일
     * @param c
     * 알파벳 대문자 -> 소문자
     * 쉼표(,) -> 세미콜론(;)
     * 괄호 [], {} -> ()
     *
     * @return c (통일)
     */
    public static char unify(char c) {
        if(c >= 'A' && c <= 'Z') c = (char) (c - 'A' + 'a');
        else if(c == ',') c = ';';
        else if(c == '{' || c == '[') c = '(';
        else if(c == '}' || c == ']') c = ')';
        return c;
    }

    public static int deleteWhiteSpace(String line, int index) {
        //이번과 다음이 ' '일 경우 index 한 칸 당기기
        while(line.charAt(index) == ' ' && index+1 < line.length() && line.charAt(index+1) == ' ') {
            index++;
        }
        return index;
    }

    public static boolean isSymbol(char c) {
        return c == ';' || c == '(' || c == ')' || c == '.';
    }
}
