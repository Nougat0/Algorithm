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
        } else if(workingCowCnt < cowCnt) {
            /*[2] 생산량 존재하나, 최소 생산량은 0*/
            sb.append(CowNumber.values()[minNonZeroMilkCow.cowNumber].name());
        } else { //모든 소가 0 이상 생산 - milkProduceList에 모두 등록됨
            int minProduce = minNonZeroMilkCow.milkProduce;
            if(milkProduceList.get(cowCnt-1).milkProduce == minProduce) {
                /*[3] 마지막 소까지 모두 최소 생산량만 생산함*/
                sb.append("Tie");
            } else {
                /*[4] 2번째 최소 생산한 소 존재*/
                Cow secondMinProduceCow = null;
                boolean multipleSecondsExist = false;
                for(int i=1; i<cowCnt; i++) {
                    Cow cow = milkProduceList.get(i);
                    if(minProduce < cow.milkProduce) {
                        if(secondMinProduceCow == null) {
                            //뒤에서 2등 자리 채우기
                            secondMinProduceCow = cow;
                        } else if(secondMinProduceCow.milkProduce == cow.milkProduce){
                            //뒤에서 2등 자리 채워졌는데 같은 2등 등장
                            multipleSecondsExist = true;
                            break;
                        } else {
                            //뒤에서 2등 자리 1마리만 존재
                            break;
                        }
                    }
                }
                if(multipleSecondsExist) {
                    sb.append("Tie");
                } else {
                    sb.append(CowNumber.values()[secondMinProduceCow.cowNumber].name());
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
