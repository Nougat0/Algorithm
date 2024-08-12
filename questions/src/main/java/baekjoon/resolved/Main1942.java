package baekjoon.resolved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer time, interval;
        int[][] intArr = new int[2][3]; //입력 for문을 위해 사용

        for(int i=0; i<3; i++) { //testCase 3개
            //입력
            interval = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                time = new StringTokenizer(interval.nextToken(), ":");
                for(int k=0; k<3; k++)
                    intArr[j][k] = Integer.parseInt(time.nextToken());
            }

            //연산
            int[] startArr = intArr[0]; //시작 시각
            int[] endArr = intArr[1]; //끝 시각
            int count = 0;
            boolean same = false;
            while(!same) {
                //3의 배수인지 확인
                if(check3ModIs0(startArr)) count++;
                //다음 수 구하기
                startArr[2]++;
                if(startArr[2] > 59) {
                    startArr[2] = 0;
                    startArr[1]++;
                }
                if(startArr[1] > 59) {
                    startArr[1] = 0;
                    startArr[0]++;
                }
                if(startArr[0] > 23) { //자정 넘김
                    startArr[0] = 0;
                    startArr[1] = 0;
                    startArr[2] = 0;
                }
                if(startArr[0] == endArr[0] && startArr[1] == endArr[1] && startArr[2] == endArr[2]) {
                    if(check3ModIs0(startArr)) count++; //마지막 수는 따로 확인
                    same = true;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    /**
     * 전달된 시간 배열의 시간정수가 3의 배수인지 확인하는 함수
     * @param arr
     * @return 3의 정수일 경우 true, 아닐 경우 false
     */
    static boolean check3ModIs0(int[] arr) {
        int num = arr[0] * 10000 + arr[1] * 100 + arr[2];
        return num % 3 == 0;
    }
}
