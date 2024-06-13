package baekjoon.processing;

import java.io.*;

public class Main1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        //분자(numerator), 분모(denominator)
        int n=1, d=1, step=7, loop=1, max=0;
        int direction = 0;
        //가로(0) -> 대각선(1) -> 세로(2) -> 대각선(3) -> (반복)
        //몇 번째 반복까지 진행해야 하는지 확인
        //loop=1, 1+2+1+3 = 2+5 7
        //loop=2, 1+4+1+5 = 2+9 loop1(+4) 11
        //loop=3, 1+6+1+7 = 2+13 loop2(+4) 15

        // 0 1 2 33
        // 0 111 2 3333
        // 0 11111 2 333333

        while(step < x) {
            step+=4;
            loop++;
        }
        //최종 loop 번째 진행 중에 x 있음

//        for()


        
        
        for(int j=0; j<loop; j++) { //직전 loop까지 진행
            //가로
            step++;
            d++;
            //대각선(밑으로)
            max=d;
            for(int i=n; i<max; i++) {
                step++;
                n++;
                d--;
            }
            //세로
            step++;
            n++;
            //대각선(위로)
            max=n;
            for(int i=d; i<max; i++) {
                step++;
                n--;
                d++;
            }
        }
        loop++;
        //마지막 loop에서 x 값 찾기
        if(step == x) System.out.printf("%d/%d\n", n, d);
        //가로
        step++;
        d++;
        if(step == x) System.out.printf("%d/%d\n", n, d);
        //대각선(밑으로)
        max=d;
        for(int i=n; i<max; i++){
            step++;
            n++;
            d--;
            if(step == x) System.out.printf("%d/%d\n", n, d);
        }
        //세로
        step++;
        n++;
        if(step == x) System.out.printf("%d/%d\n", n, d);
        //대각선(위로)
        max=n;
        for(int i=d; i<max; i++) {
            step++;
            n--;
            d++;
            if(step == x) System.out.printf("%d/%d\n", n, d);
        }

    }
}
