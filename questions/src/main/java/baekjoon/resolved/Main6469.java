package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6469 {
    /*
    initial seed (최초 시드) = seed(0) = 문제에서는 0으로 두었으나 아무 값을 사용해도 괜찮음
    결국 seedFunc 는 특정 시드값들을 반복해서 리턴하는 단점을 필연적으로 갖는데,
    이 단점을 보완하기 위해 step 과 mod 값을 조정하여 0 ~ mod-1 값이 모두 시드값으로 리턴되는 Seed를 찾아낼 것.
    -> 입력값 중 그런 경우와 그러지 못하는 경우를 구분하여 출력하자
     */
    public static final int INIT_SEED = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        
        while((line = br.readLine()) != null) { //EOF 감지
            st = new StringTokenizer(line);
            Seed seed = new Seed(st.nextToken(), st.nextToken());
            sb.append(seed.print());
            sb.append("\n\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * Seed 클래스 구현
     */
    public static class Seed {
        int stepLength;
        int modLength;
        int step;
        int mod;
        boolean[] seedGenerated; //seed(index) 도출 여부 기록용
        int[] seedList; //도출된 seed 값 (index = x)
        boolean goodChoice; //0 ~ MOD-1 의 모든 값이 도출 되는지 여부

        //생성자
        public Seed(String step, String mod) {
            this.step = Integer.parseInt(step);
            this.mod = Integer.parseInt(mod);
            stepLength = step.length();
            modLength = mod.length();
            seedGenerated = new boolean[this.mod];
            seedGenerated[INIT_SEED] = true; //초기 시드는 이미 구해졌음을 명시
            seedList = new int[this.mod];
            checkSeed(); //균등한 시드인지 확인
        }

        /**
         * seed(x) 함수 구현
         * 시드값 구할 때 Memoization 적용
         * @param x
         * @return
         */
        public int seedFunc(int x) {
            if(x == 0) {
                return INIT_SEED;
            } else if(!seedGenerated[x]) {
                //seed(x) 구하기
                seedList[x] = (seedFunc(x-1) + step) % mod;
                seedGenerated[x] = true;
            }
            return seedList[x];
        }

        /**
         * 균등한 분배가 이루어진 seed인지 확인, 확인 결과를 goodChoice에 추가
         * (알맞은 step과 mod 값을 선정했는지)
         */
        public void checkSeed() {
            boolean inLoop = true, goodChoice = true;
            //[1] seed 도출하기
            // (최대 MOD 개수만큼 존재한다고 가정...)
            // MOD 보다 많이 봐야 하는 경우도 있나? x의 최대값 정하기가 난감하네
            for(int x=1; x<mod && inLoop; x++) {
                if(this.seedFunc(x) == INIT_SEED) {
                    inLoop = false;
                }
            }
            //[2] 빠진 seed 있는지 확인
            for(int i=0; i<mod && goodChoice; i++) {
                if(!seedGenerated[i]) {
                    goodChoice = false;
                }
            }
            this.goodChoice = goodChoice;
        }

        /**
         * 시드 출력
         * @return 출력값 StringBuilder
         */
        public StringBuilder print() {
            StringBuilder sb = new StringBuilder();
            sb.append(" ".repeat(10 - this.stepLength)).append(this.step);
            sb.append(" ".repeat(10 - this.modLength)).append(this.mod);
            sb.append(' ').append(this.goodChoice ? "Good" : "Bad").append(' ').append("Choice");
            return sb;
        }
    }
}
