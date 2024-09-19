package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력
        int arrSize = Integer.parseInt(st.nextToken());
        int repeatTimes = Integer.parseInt(st.nextToken());
        int[] arr = new int[arrSize];
        st = new StringTokenizer(br.readLine(), ",");
        for(int i=0; i<arrSize; i++) arr[i] = Integer.parseInt(st.nextToken());
        //A->B 과정 반복
        for(int i=0; i<repeatTimes; i++) arr = processArr(arr);
        //출력
        bw.write(Arrays.toString(arr).replaceAll("\\[|\\]| ", ""));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 입력된 배열 arr로 배열 B 만들기
     * @param arr
     * @return 배열 B
     */
    public static int[] processArr(int[] arr) {
        int arrSize = arr.length;
        int[] processedArr = new int[arrSize-1];
        for(int i=0; i<processedArr.length; i++)
            processedArr[i] = arr[i+1] - arr[i];
        return processedArr;
    }
}
