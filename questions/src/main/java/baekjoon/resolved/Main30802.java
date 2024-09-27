package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int totalPart = Integer.parseInt(br.readLine());
        int[] tShirt = new int[6];
        StringTokenizer tShirtSizeCnt = new StringTokenizer(br.readLine()); //티셔츠 사이즈별 수요
        StringTokenizer bundleCnt = new StringTokenizer(br.readLine()); //묶음 단위
        int tBundle = Integer.parseInt(bundleCnt.nextToken());
        int penBundle = Integer.parseInt(bundleCnt.nextToken());
        int tOrder = 0;
        //연산 및 출력
        for(int i=0; i<6; i++) { //티셔츠 사이즈별 수요 조사 및 주문 계산
            tShirt[i] = Integer.parseInt(tShirtSizeCnt.nextToken());
            tOrder += tShirt[i]/tBundle + (tShirt[i]%tBundle > 0 ? 1 : 0); //티셔츠 묶음 초과구매
        }
        bw.write(String.format("%d%n%d %d%n", tOrder, totalPart/penBundle, totalPart%penBundle));
        bw.flush();
        bw.close();
        br.close();
    }
}
