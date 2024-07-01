package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        //데이터 구성
        boolean nInS = false;
        int[] s = new int[l];
        for(int i=0; i<l; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            if(s[i] == n) { //좋은구간이 없는 경우 반복문 탈출
                nInS = true;
                break;
            }
        }

        if(nInS) { //좋은구간이 없는 경우 바로 출력
            bw.write(0+"\n");
        } else { //좋은구간 범위 찾기
            Arrays.sort(s);
            int from=0, to=0; //좋은구간 숫자 범위
            if(s[0] > n) { //가장 작은 집합 정수보다 n이 작을 경우
                from = 1;
                to = s[0] - 1;
            } else { //집합 정수들 사이에 n이 위치할 경우
                for(int i=0; i<l-1; i++)
                    if(s[i] < n && s[i+1] > n) {
                        from = s[i] + 1;
                        to = s[i+1] - 1;
                        break;
                    }
            }
            int count = 0; //좋은구간 세기
            for(int i=from; i<to; i++)
                for(int j=i+1; j<=to; j++)
                    if(n>=i && n<=j) {
                        //bw.write(String.format("[%d, %d]%n", i, j));
                        count++;
                    }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
