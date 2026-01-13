package baekjoon.processing;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main11009 {
    /*
        https://www.acmicpc.net/problem/11009
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int NUMERATOR = 0;
    public static final int DENOMINATOR = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        /*
            테스트 케이스별로 확률 분수 구하기
        */
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int RED_BALLS = Integer.parseInt(st.nextToken());
            final int WHITE_BALLS = Integer.parseInt(st.nextToken());

            BigDecimal[] fraction = null; //매 차례별 확률 누적값
            BigDecimal[] winningFraction = new BigDecimal[2]; //빨간공 뽑기 직전까지의 확률(다음차례에 재활용)
            /*
                이전에 계산한 확률 누적값 재사용하기 위한 변수들
            */
            winningFraction[NUMERATOR] = BigDecimal.ONE;
            winningFraction[DENOMINATOR] = BigDecimal.ONE;
            /*
                dreamoon이 매 차례마다 빨간 공 뽑을 확률
                (1번째, 3번째, 5번째... 에 뽑을 확률)
            */
            for(int i=1, loop=-1; i<=(WHITE_BALLS + 1); i+=2, loop++) {
                boolean usingSavedValue = loop > 0;

                BigDecimal numerator = winningFraction[NUMERATOR];
                BigDecimal denominator = winningFraction[DENOMINATOR];

                int whiteBallLoopValue = usingSavedValue ? WHITE_BALLS-(loop+1) : WHITE_BALLS;
                int redBallLoopValue = RED_BALLS;

                //연산 시작위치 지정 (확률 누적값 이후 이어서 연산)
                int startIndex = usingSavedValue ? i-2 : 1;
                /*
                    흰 공 뽑는 경우의 수 (j < i)
                */
                for(int j=startIndex; j<i; j++) {
                    denominator = denominator.multiply(BigDecimal.valueOf(redBallLoopValue + whiteBallLoopValue));
                    numerator = numerator.multiply(BigDecimal.valueOf(whiteBallLoopValue--));
                }
                //흰 공 뽑는 확률 저장 (+ 약분)
                BigDecimal gcd = getGCD(numerator, denominator);
                winningFraction[NUMERATOR] = (numerator = numerator.divide(gcd));
                winningFraction[DENOMINATOR] = (denominator = denominator.divide(gcd));
                /*
                    [마지막]
                    빨간 공 뽑는 경우의 수 (j = i)
                */
                denominator = denominator.multiply(BigDecimal.valueOf(redBallLoopValue + whiteBallLoopValue));
                numerator = numerator.multiply(BigDecimal.valueOf(redBallLoopValue));
                //약분하기
                gcd = getGCD(numerator, denominator);
                numerator = numerator.divide(gcd);
                denominator = denominator.divide(gcd);
                //지난차례와 이번차례의 확률 덧셈
                if(fraction == null) fraction = new BigDecimal[] {numerator, denominator};
                else fraction = addFractions(numerator, denominator, fraction[NUMERATOR], fraction[DENOMINATOR]);
            }
            //약분하기
            BigDecimal gcd = getGCD(fraction[NUMERATOR], fraction[DENOMINATOR]);
            sb.append(fraction[NUMERATOR].divide(gcd)).append('/').append(fraction[DENOMINATOR].divide(gcd)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 두 수의 최대공약수 구하기
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal getGCD(BigDecimal a, BigDecimal b) {
        BigDecimal remainder;
        while((a.remainder(b).compareTo(BigDecimal.ZERO) != 0)) {
            remainder = a.remainder(b);
            a = b;
            b = remainder;
        }
        return b;
    }

    /**
     * 분수 더하기
     * @param a_numerator a 분자
     * @param a_denominator a 분모
     * @param b_numerator b 분자
     * @param b_denominator b 분모
     * @return a분자/a분모 + b분자/b분모
     */
    public static BigDecimal[] addFractions(BigDecimal a_numerator, BigDecimal a_denominator, BigDecimal b_numerator, BigDecimal b_denominator) {
        BigDecimal[] result = new BigDecimal[2];
        BigDecimal gcd = getGCD(a_denominator, b_denominator);
        BigDecimal lcm = a_denominator.multiply(b_denominator).divide(gcd);
        result[NUMERATOR] = (lcm.divide(a_denominator).multiply(a_numerator)).add(lcm.divide(b_denominator).multiply(b_numerator));
        result[DENOMINATOR] = lcm;
        //약분하기
        gcd = getGCD(result[NUMERATOR], result[DENOMINATOR]);
        result[NUMERATOR] = result[NUMERATOR].divide(gcd);
        result[DENOMINATOR] = result[DENOMINATOR].divide(gcd);
        return result;
    }
}
