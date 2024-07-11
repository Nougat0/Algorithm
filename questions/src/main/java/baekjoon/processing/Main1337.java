package baekjoon.processing;

import java.io.*;
import java.util.Arrays;

public class Main1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];
        int[] interval = new int[arrSize-1];

        for(int i=0; i<arrSize; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        /*
        이거 이제보니 간단하게 연속인 게 몇 개 있냐~~ 가 아니라
        ABCDE -> A C E만 있어도 B, D 2개 추가하면 되겠네요 하는 문제임
        정렬한 후... 숫자 사이사이 간격을 체크해야 할 듯
        interval 배열 정의해서 사용하기
        */
        bw.flush();
        bw.close();
        br.close();
    }
}
