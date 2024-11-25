package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        /*공통변수 선언*/
        int ancestors; //주어지는 조상 trait 수
        int length; //trait 의 길이
        char[][] stringList; //trait 목록 (본인 + 조상)
        boolean[] inherited; //trait 각 위치의 유전여부
        /*입력 및 연산*/
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            st = new StringTokenizer(br.readLine());
            ancestors = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            stringList = new char[ancestors+1][length];
            inherited = new boolean[length];
            //한 번이라도 조상의 유전자 중에 같은 위치에 같은 trait이 있을 경우 유전받은 것
            stringList[0] = br.readLine().toCharArray();
            for(int a=1; a<ancestors+1; a++) {
                stringList[a] = br.readLine().toCharArray();
                for(int s=0; s<length; s++) 
                    if(!inherited[s] && stringList[a][s] == stringList[0][s]) 
                        inherited[s] = true;
            }
            //돌연변이 trait의 수 세기
            int mutantTraits = 0;
            for(boolean inherit : inherited)
                if(!inherit) mutantTraits++;
            //출력문 작성
            sb.append("Data Set ").append(t).append(":\n")
                .append(mutantTraits).append("/").append(length);
            if(t<testCase) sb.append("\n\n");
        }
        /*출력*/
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
