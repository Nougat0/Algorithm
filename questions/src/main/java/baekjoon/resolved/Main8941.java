package baekjoon.resolved;

import java.io.*;

public class Main8941 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/8941
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        // 괄호가 나온다는 얘기가 없었으니 안심해도 되겠지..?
        while(testCases-- > 0) {
            String line = br.readLine();
            double molarMass = getMolarMassSum(line);
            sb.append(String.format("%.3f", molarMass)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //화학식에 대한 molarMass 구하기
    private static double getMolarMassSum(String line) {
        double molarMassSum = 0.00;
        double molarMass = 0.0;
        for(int i = 0; i< line.length(); i++) {
            char c = line.charAt(i);
            if(c <= '9') { //숫자
                int number = c - '0';
                //2자릿수인지 체크
                if(i < line.length()-1 && line.charAt(i+1) <= '9') {
                    number = number * 10 + (line.charAt(i+1) - '0');
                    i++;
                }
                //합산
                molarMassSum += (molarMass * number);
            } else { //알파벳
                molarMass = getMolarMass(c);
                //1개라면 바로 합산 + 마지막이어도 합산
                if(i < line.length()-1 && line.charAt(i+1) >= 'A' 
                        || i == line.length()-1) {
                    molarMassSum += molarMass;
                }
            }
        }
        return molarMassSum;
    }

    public static double getMolarMass(char c) {
        switch(c) {
            case 'C': return 12.01;
            case 'H': return 1.008;
            case 'O': return 16.00;
            default: return 14.01;
        }
    }
}
