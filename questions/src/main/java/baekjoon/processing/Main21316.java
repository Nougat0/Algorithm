package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main21316 {
    /*
    Spica 별 : 3개의 연결선 가짐, 연결된 3개 점 중 하나는 Spica가 유일한 연결고리
    각 별이 가진 연결선 개수까지는 쉽게 저장이 가능한데, 연결정보는 어떻게 저장할지...
    결국 1) 연결선 개수 저장, 2) 연결점 정보 저장 (최대 3개) 2개 배열을 사용함.
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int stars = 12, a, b, spica = 0;
        int[][] starList = new int[stars+1][3]; //별 연결정보
        int[] linkCount = new int[stars+1]; //별 링크개수 1~3
        //입력
        while(stars-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            starList[a][linkCount[a]++] = b;
            starList[b][linkCount[b]++] = a;
        }
        //연산
        stars = 12;
        foundSpica:
        while(stars-- > 0)
            if(linkCount[stars] == 3) //spica 후보군
                for(int linkedStar : starList[stars]) //후보군과 연결된 별들 순회
                    if(linkCount[linkedStar] == 1) { //연결점이 1개인 별이 있는지 확인
                        spica = stars; //있다면 stars 가 spica이다
                        break foundSpica;
                    }
        bw.write(spica + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
