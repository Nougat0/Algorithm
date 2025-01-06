package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int length = Integer.parseInt(br.readLine());
        int[] array = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isSequence = true;
        //등차 구하기
        array[0] = Integer.parseInt(st.nextToken());
        if(length > 1) { //길이가 2이상일 경우에만 등차수열 체크
            array[1] = Integer.parseInt(st.nextToken());
            final int diff = array[1] - array[0];
            //array가 등차수열이 맞는지 체크
            for(int i=2; i<length && isSequence; i++) {
                array[i] = Integer.parseInt(st.nextToken());
                if(array[i] - array[i-1] != diff) {
                    isSequence = false;
                }
            }
        }
        //array의 형태에 따른 출력
        if(isSequence) {
            sb.append("YES").append("\n");
            StringBuilder arrayB = new StringBuilder(); //array의 반전값
            StringBuilder arrayC = new StringBuilder(); //array - arrayB
            int valueB, valueC;
            //B와 C 수열값 출력하기 - B와 C의 등차에 대한 제한이 없음!
            for(int i=0; i<length; i++) {
                valueB = -array[i]; //반대값
                valueC = array[i] - valueB; //차이값
                arrayB.append(valueB).append(" ");
                arrayC.append(valueC).append(" ");
            }
            sb.append(arrayB).append("\n").append(arrayC);
        } else {
            sb.append("NO");
        }
        //출력!
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
