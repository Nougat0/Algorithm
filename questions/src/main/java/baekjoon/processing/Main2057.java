package baekjoon.processing;

import java.io.*;

public class Main2057 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2057
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long N = Long.parseLong(br.readLine());

        //팩토리얼값 미리 계산
        long[] factorial = new long[21]; //20! = 2_432_902_008_176_640_000L
        factorial[0] = 1;
        int count = 0;
        while(factorial[count] <= N) {
            factorial[count + 1] = factorial[count] * (count + 1);
            count++;
        }

        //정답 체크 - 질문글 참고 (https://www.acmicpc.net/board/view/106975)
        /**
         * n! >= (n-1)! + (n-2)! + ... + 2! + 1! + 0! 이므로
         * long N 이 팩토리얼의 합산으로 나타낼 수 있는지는
         * k! <= N < (k+1)! 를 만족하는 k! 부터 하나씩 빼서 확인하면 끝
         *
         * 즉, N 보다 작은 팩토리얼들을 전부 빼도 N이랑 같을까말까이니
         * 전부 합해서 N을 만들 수 있는지에 대한 조합은 1가지 뿐이다
         */
        long result = N;
        for(int i=count-1; i>=0 && result > 0; i--) { //result == 0 되면 break
            result -= factorial[i];
        }
        if(N > 0 && result == 0) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}
