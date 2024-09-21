package baekjoon.resolved;

import java.io.*;

public class Main1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int number = Integer.parseInt(br.readLine());
        //금민수 확인
        int goldMin = 0;
        for(int i=number; i>0; i--)
            if(checkGoldMin(i)) {
                goldMin = i;
                break;
            }
        //출력
        bw.write(goldMin + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 금민수인지 확인하고 반환하는 로직
     * @param number 확인할 수
     * return number가 금민수인지 여부
     */
    public static boolean checkGoldMin(int number) {
        boolean isGoldMin = true;
        //n 자릿수 확인 (n>1)
        while(number/10 > 0) {
            if(!(number%10 == 4 || number%10 == 7)) {
                isGoldMin = false;
                break;
            }
            number /= 10;
        }
        //1의 자릿수 확인
        if(!(number%10 == 4 || number%10 == 7)) isGoldMin = false;
        return isGoldMin;
    }
}
