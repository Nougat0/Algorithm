package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*
        접근개념: List(n) = {a+0, a+1, a+2, ... a+n-1}
        */
        int sum = Integer.parseInt(st.nextToken()); //합계
        final int length = Integer.parseInt(st.nextToken()); //최소길이

        int finalLength = length; //최종길이, 최소길이로 초기화
        for(int i=1; i<finalLength; i++) {
            sum -= i;
            if(i >= length-1) { //반복횟수가 최소길이와 같거나 클 때
                if(sum%finalLength != 0) finalLength++;
                else break; //현재 최종길이 사용
            }
        }

        if(finalLength <= 100 && sum >= 0) { //출력조건 확인
            int start = sum/finalLength; //리스트의 첫 번째 숫자
            for(int i=0; i<finalLength; i++) {
                bw.write(String.valueOf(start+i)); //리스트 숫자 출력
                if(i < finalLength-1) bw.write(" "); //공백 출력
            }
        } else {
            bw.write("-1\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
