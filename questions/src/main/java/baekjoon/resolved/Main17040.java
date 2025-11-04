package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17040 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/17040
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] fieldSelect = new int[n+1][n+1]; //소들의 선택
        int[] fields = new int[n+1]; //목초지에 뿌릴 잔디 번호
        boolean[] grassUsed; //사용가능한 잔디 번호 기록용
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            fieldSelect[a][b]++;
            fieldSelect[b][a]++;
        }
        fields[1] = 1; //첫 번째 필드는 무조건 1 (최소값)
        //목초지를 선택한 소들의 다른 선택값이 아닌 잔디 번호 선택하기
        for(int f=2; f<=n; f++) {
            int usableGrassNo = 5;
            grassUsed = new boolean[n+1];
            //이번 목초지를 원하는 소들의 타 선택지 확인
            for(int i=1; i<=n; i++) {
                int grass = fields[i];
                if(fieldSelect[f][i] > 0 && grass > 0) {
                    grassUsed[grass] = true;
                }
            }
            //안 쓴 잔디번호 찾기(최소)
            for(int i=1; i<=n; i++) {
                if(!grassUsed[i]) {
                    usableGrassNo = i;
                    break;
                }
            }
            fields[f] = usableGrassNo;
        }
        //출력
        for(int f=1; f<=n; f++) {
            sb.append(fields[f]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
