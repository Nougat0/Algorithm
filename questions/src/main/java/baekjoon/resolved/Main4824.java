package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            float[] dimensions = new float[3];
            boolean isEnd = true;
            //입력 및 종료 조건 확인
            for(int i=0; i<3; i++) {
                dimensions[i] = Float.parseFloat(st.nextToken());
                isEnd &= (dimensions[i] == 0);
            }
            if(isEnd) break;
            //우편물 종류 확인
            Arrays.sort(dimensions); //오름차순 정렬 -> thickness, height, length
            float thickness = dimensions[0];
            float height = dimensions[1];
            float length = dimensions[2];
            if(length >= 125 && height >= 90 && thickness >= 0.25) { //편지 최소조건(공통)
                if(length <= 290 && height <= 155 && thickness <= 7) { //편지 최대조건
                    sb.append("letter");
                } else {
                    if(length <= 380 && height <= 300 && thickness <= 50) { //패킷 최대조건
                        sb.append("packet");
                    } else if((height + thickness)*2 + length <= 2100) { //소포 최대조건
                        //girth : length 와 수직인 둘레
                        sb.append("parcel");
                    } else {
                        sb.append("not mailable");
                    }
                }
            } else {
                sb.append("not mailable");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
