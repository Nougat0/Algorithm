package baekjoon.resolved;

import java.io.*;

public class Main6794 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/6794
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        /*
            number ~ 0까지 나열해서 숫자 사이에 구분선을 둔다고 하면,
            가운데 혹은 가운데 2개 중 왼쪽 구분선까지만 사용 가능
            (왼쪽 개수가 크도록 정렬되어있으므로)

            + 한 손으로는 최대 5개까지만 표시 가능...
        */
        int middle = number/2 + 1;
        if(number <= 5) System.out.println(middle);
        else System.out.println(middle - (number - 5 + 1) + 1);
        br.close();
    }
}
