package baekjoon.contest;

import java.io.*;
import java.util.StringTokenizer;

public class Main1469_D {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1469/4
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // 하나의 도형은 왼/오 2층 총 4부분으로 나눠서 막혔는지 / 뚫렸는지 확인 가능
        // 위아래는 항상 막혀있음
        // 왼쪽과 오른쪽은 둘 다 뚫리거나 막힌 경우는 없음
        // 막힌 부분과 뚫린 부분이 만나면 기차간이 된다...?

        // 사실 기차칸 모양이 4가지 밖에 없어서... 그냥 경우의 수로 미리 계산해놔도 되긴 할 듯
        // 직접 그려보니 2-2, 5-5 일 때 2개, ]-[ 일 때 0개 그 외에는 전부 1개 만들어짐
        char[] train = br.readLine().toCharArray();
        char before = train[0];
        char after;
        int roomCount = 0;
        for(int i=1; i<n; i++) {
            after = train[i];
            if(before == after && (before == '5' || before == '2')) roomCount += 2;
            else if(!(before == ']' && after == '[')) roomCount += 1;
            before = after;
        }
        bw.write(roomCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
