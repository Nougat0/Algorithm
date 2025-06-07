package baekjoon.resolved;

import java.io.*;

public class Main28702 {
    /*
        https://www.acmicpc.net/problem/28702
        https://www.acmicpc.net/user/bcdlife
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int lastNumber = -1;
        //정말 연속된 숫자들을 출력하고 있는가? 아니면 특정 규칙에 의한 숫자들을 출력하는지...?
        for(int i=0; i<3; i++) {
            String line = br.readLine();
            if(lastNumber == -1) {
                FizzBuzz fizzBuzz = new FizzBuzz(line);
                if(fizzBuzz.hasNumber) lastNumber = fizzBuzz.number + (3-i);
            }
        }
        //출력
        FizzBuzz lastNumberAsFizzBuzz = new FizzBuzz(lastNumber);
        if(lastNumberAsFizzBuzz.multipleOf3 && lastNumberAsFizzBuzz.multipleOf5) bw.write("FizzBuzz");
        else if(lastNumberAsFizzBuzz.multipleOf3) bw.write("Fizz");
        else if(lastNumberAsFizzBuzz.multipleOf5) bw.write("Buzz");
        else bw.write(lastNumberAsFizzBuzz.number + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class FizzBuzz {
        boolean multipleOf3; //Fizz
        boolean multipleOf5; //Buzz
        boolean hasNumber; //숫자인지 문자인지
        int number; //숫자

        //입력값 저장용 생성자
        public FizzBuzz(String number) {
            try {
                this.number = Integer.parseInt(number);
                this.hasNumber = true;
            } catch(NumberFormatException e) {
                multipleOf3 = number.indexOf('F') >= 0;
                multipleOf5 = number.indexOf('B') >= 0;
                this.hasNumber = false;
            }
        }

        //마지막 숫자 추측 시 사용되는 생성자
        public FizzBuzz(int number) {
            multipleOf5 = number % 5 == 0;
            multipleOf3 = number % 3 == 0;
            hasNumber = true;
            this.number = number;
        }
    }
}
