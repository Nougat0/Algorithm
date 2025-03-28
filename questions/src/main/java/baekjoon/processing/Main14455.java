package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main14455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int logCnt = Integer.parseInt(br.readLine());
        List<Cow> milkProduceList = new ArrayList<>();
        int cowCnt = CowNumber.values().length;
        int[] cowsMilkProduce = new int[cowCnt];
        /*로그 해석*/
        for(int i=0; i<logCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int milkProduce = Integer.parseInt(st.nextToken());
            cowsMilkProduce[CowNumber.valueOf(name).ordinal()] += milkProduce;
        }
        /*일한 소들만 취합*/
        int workingCowCnt = 0;
        for(int i=0; i<cowCnt; i++) {
            int milkProduce = cowsMilkProduce[i];
            if(milkProduce > 0) {
                milkProduceList.add(new Cow(i, milkProduce));
                workingCowCnt++;
            }
        }
        /*우유생산량 기준으로 오름차순 정렬*/
        Collections.sort(milkProduceList, Comparator.comparingInt(c -> c.milkProduce));
        /**
         * 가장 좋은 순위 차지한 소는 누구 ?
         * Tie: 뒤에서 2등 자리에 0마리가 있거나, 여러 마리가 있을 경우 출력
         */
        Cow minNonZeroMilkCow = milkProduceList.get(0);
        if(workingCowCnt == 0) {
            /*[1] 아무도 우유 생산을 안했다!*/
            sb.append("Tie");
        } else {
            /**
             * 우유 생산을 N(1<=N<=7) 마리 했음
             * 최소 생산량은 0일수도, 양수일 수도 있다!
             */
            int minNonZeroMilkProduce = minNonZeroMilkCow.milkProduce;
            /*[2] 모두 동일한 생산량*/
            if(milkProduceList.get(workingCowCnt-1).milkProduce == minNonZeroMilkProduce) {
                sb.append("Tie"); //2등 다수, 1등 다수 모두 Tie
            } else {
                /*[3] 뒤에서 3등 이상 존재*/
                boolean allCowsWorking = workingCowCnt == cowCnt;
                //초기값 최소생산량에 따라 다르게 설정
                int minProduceMilk = allCowsWorking ? minNonZeroMilkProduce : 0;
                int startIndex = allCowsWorking ? 1 : 0;
                //지정된 최소생산량보다 큰 값 찾기
                int secondMinProduceMilk = -1, secondMinProduceMilkCowNum = -1;
                boolean isTie = false;
                for(int i=startIndex; i<workingCowCnt; i++) {
                    Cow cow = milkProduceList.get(i);
                    if(cow.milkProduce > minProduceMilk) {
                        if(secondMinProduceMilk == -1) { //첫번째 뒤에서 2등 소
                            secondMinProduceMilk = cow.milkProduce;
                            secondMinProduceMilkCowNum = cow.cowNumber;
                        } else if(secondMinProduceMilk == cow.milkProduce) { //두번째 뒤에서 2등 소
                            isTie = true;
                            break;
                        } else { //뒤에서 3등 소
                            break;
                        }
                    }
                }
                if(isTie) {
                    sb.append("Tie");
                } else {
                    sb.append(CowNumber.values()[secondMinProduceMilkCowNum].name());
                }
            }
        }
        bw.write(sb.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 소 순서 관리용 enum
     * 임의로 번호를 매겨서 관리
     */
    public enum CowNumber {
        Bessie, Elsie, Daisy, Gertie, Annabelle, Maggie, Henrietta;
    }

    /**
     * 소 관리 클래스
     */
    public static class Cow {
        int cowNumber; //소 번호 (CowNumber enum 나열순서 사용)
        int milkProduce; //우유 생산량 (0이상만 기록)
        public Cow(int cowNumber, int milkProduce) {
            this.cowNumber = cowNumber;
            this.milkProduce = milkProduce;
        }
    }
}
