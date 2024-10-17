package baekjoon.processing;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main6147 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCows = Integer.parseInt(st.nextToken());
        Integer[] cows = new Integer[totalCows];
        int bookshelfHeight = Integer.parseInt(st.nextToken());
        for(int cow=0; cow<totalCows; cow++) cows[cow] = Integer.parseInt(br.readLine());

        //소들이 서로 위에 올라서서 책장높이를 넘길 수 있는 최소 개체수를 구하기 -> 큰 높이부터 더하면 됨
        Arrays.sort(cows, Collections.reverseOrder()); //내림차순 정렬
        int cowTowerHeight = 0;
        int cowIndex = 0;
        while(cowTowerHeight < bookshelfHeight) { //cowIndex < totalCows 보장됨.
            cowTowerHeight += cows[cowIndex];
            cowIndex++; //연산 후에 증가시켜서 총 사용된 소의 수를 나타내는 값으로도 사용.
        }
        bw.write(cowIndex + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
