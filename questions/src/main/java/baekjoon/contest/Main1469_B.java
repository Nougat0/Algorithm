package baekjoon.contest;

import java.io.*;

public class Main1469_B {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1469/2
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[6]; //0배열 안 사용함
        int sum = 0;
        //전체: 21
        //5면 드러나는 경우 최대: 전체-1, 최소: 전체-6
        //4면 드러나는 경우 최대: 전체-2-1, 최소: 전체-6-5
        //3면 드러나는 경우 최대: 전체-3-2-1, 최소: 전체-6-5-4
        //2면 드러나는 경우 최대: 6+5, 최소: 1+2
        //1면 드러나는 경우 최대: 6, 최소: 1

        //각 층별로 N면 드러나는 개수 규칙을 파악해서 연산하기
        int m = n - 2;
        int addSum = m * (m + 1) / 2;
        count[5] = 1; //맨 위
        count[4] = (n - 1) * 2; //양 끝
        count[3] = addSum; //안쪽
        count[2] = n - 1; //꼭지점 1개
        count[1] = addSum * 2; //뒤쪽 안쪽
        //최소 최대 굳이 구분할 필요 없으니 그냥 같이 구하기
        sum += count[5] * (21-1 + 21-6);
        sum += count[4] * (21-3 + 21-11);
        sum += count[3] * 21;
        sum += count[2] * (11 + 3);
        sum += count[1] * 7;
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
