package baekjoon.resolved;

import java.io.*;

public class Main9012 {
    public static final String isVPS = "YES";
    public static final String notVPS = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            int opened = 0; //0이하로 내려갈 일이 없어야 VPS
            char[] line = br.readLine().toCharArray();
            //opened < 0 경우 = opened 없이 closed 등장 = notVPS = 이후 문자열 확인할 필요 없음
            for(int j=0; j<line.length && opened>=0; j++)
                if(line[j] == '(') opened++;
                else if(line[j] == ')') opened--; //closed 와 같다
            bw.write(opened == 0 ? isVPS : notVPS);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
