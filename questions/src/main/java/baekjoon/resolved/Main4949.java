package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4949 {
    public static final char endMark = '.';
    public static final String isBalanced = "yes";
    public static final String notBalanced = "no";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line;
        while((line = br.readLine().toCharArray())[0] != endMark) {
            //열린 괄호 목록, 대괄호=true, 소괄호=false
            List<Boolean> depth = new ArrayList<>(); 
            boolean balanced = true;
            for(int i=0; balanced && i<line.length-1; i++) {
                char thisChar = line[i];
                /** 열림 **/
                if(thisChar=='(' || thisChar=='[')
                    depth.add(thisChar=='[');
                /** 닫힘 **/
                else if(thisChar==')' || thisChar==']')
                    if(depth.size() == 0) balanced = false; //열리지 않았는데 닫기
                    else { //짝 맞는지 확인
                        int lastIdx = depth.size() - 1;
                        //짝 맞으면 해당 Depth 닫기
                        if (!(depth.get(lastIdx) ^ thisChar==']')) depth.remove(lastIdx);
                        else balanced = false; //안 맞는 짝으로 닫기
                    }
            }
            bw.write(balanced && depth.size()==0 ? isBalanced : notBalanced);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
