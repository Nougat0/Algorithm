package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=1; i<=testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            /*
            둘 다 결국 얻어야 하는 건 같다
            최상단 노드 ~ 대상 노드까지의 길목(방향) 정보
             */
            sb.append("Case #").append(i).append(": ");
            int p, q; //p, q 값
            int power = 0, horizonPos = 0; //행, 열
            boolean[] path; //길목 정보
            switch(id) {
                case 1: //N번째 요소 찾기
                    //[1] 몇 번째 줄에 있는지 확인
                    int n = Integer.parseInt(st.nextToken());
                    int number = n;
                    int lineStart = 1; //위치한 행의 시작점 번호
                    while((number/=2) > 0) {
                        power++;
                        lineStart *= 2;
                    }
                    horizonPos = n % lineStart + 1; //몇 번째인지 확인 -- 1이면 lineStart과 동일
                    //[2] 거슬러 올라가기
                    path = new boolean[power];
                    for(int j=0; j<power; j++) {
                        path[power-1-j] = (horizonPos % 2 == 0); //왼쪽: false, 오른쪽: true
                        horizonPos = (horizonPos + 1)/2;
                    }
                    //[3] 다시 내려가기 - p, q 연산
                    p = 1;
                    q = 1;
                    for(int j=0; j<power; j++) {
                        if(path[j]) {
                            p += q;
                        } else {
                            q += p;
                        }
                    }
                    sb.append(p).append(' ').append(q);
                    break;
                case 2: //p와 q로 순번 도출
                    p = Integer.parseInt(st.nextToken());
                    q = Integer.parseInt(st.nextToken());
                    //[1] p/q -> 1/1 올라가기
                    path = new boolean[16];
                    while(!(p == 1 && q == 1)) {
                        if(path[power++] = p > q) { //왼쪽: false, 오른쪽: true
                            p -= q;
                        } else { //왼쪽
                            q -= p;
                        }
                    }
                    //[2] 1/1 에서 내려가기
                    horizonPos = 1;
                    for(int j=0; j<power; j++) {
                        horizonPos *= 2;
                        if(!path[power-1-j]) {
                            horizonPos--;
                        }
                    }
                    //[3] N 계산
                    int pow = 1;
                    while(power-->0) pow *= 2;
                    sb.append(pow + horizonPos - 1);
                    break;
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
