package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main27535 {
    /*
        https://www.acmicpc.net/problem/27535
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int CHOCO_TYPE_CNT = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] chocoRemains = new int[CHOCO_TYPE_CNT];
        Integer[] originIndexes;
        int totalCnt = 0, lastObservedTotalCnt, cnt;
        //HTCKG 순서로 입력됨
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<CHOCO_TYPE_CNT; i++) {
            cnt = Integer.parseInt(st.nextToken());
            chocoRemains[i] = cnt;
            totalCnt += cnt;
        }
        int logCnt = Integer.parseInt(br.readLine());
        while(logCnt-- > 0) {
            lastObservedTotalCnt = totalCnt;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<CHOCO_TYPE_CNT; i++) {
                cnt = Integer.parseInt(st.nextToken());
                chocoRemains[i] -= cnt;
                totalCnt -= cnt;
            }
            //초콜릿 점호 (1):전체개수
            switch(lastObservedTotalCnt % 10) {
                case 0: case 1:
                    sb.append(totalCnt);
                    break;
                default:
                    sb.append(Integer.toString(totalCnt, lastObservedTotalCnt % 10));
            }
            sb.append("7H\n");
            //개수별로 정렬
            originIndexes = new Integer[]{0,1,2,3,4}; //인덱스 관리용 배열
            /*
                정렬기준: 종류별로 남은 초콜릿 개수
                정렬대상: 해당 종류의 인덱스
            */
            Arrays.sort(originIndexes, (i1, i2) -> {
                int compareResult = Integer.compare(chocoRemains[i2], chocoRemains[i1]);
                if(compareResult == 0) { //같은 값일 시 알파벳(char) 비교 --> 오름차순 정렬
                    return ChocoType.getFromOrdinal(i1) - ChocoType.getFromOrdinal(i2);
                } else { //내림차순 정렬
                    return compareResult;
                }
            });
            //초콜릿 점호 (2):개별개수
            if(totalCnt == 0) {
                sb.append("NULL\n");
            } else {
                for(int i=0; i<CHOCO_TYPE_CNT; i++) {
                    int indexOfOrigin = originIndexes[i];
                    cnt = chocoRemains[indexOfOrigin];
                    if(cnt > 0) {
                        sb.append(ChocoType.getFromOrdinal(indexOfOrigin));
                    } else {
                        break;
                    }
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 초콜릿 종류 입력순서 관리용 enum
     */
    public enum ChocoType {
        H, T, C, K, G;
        public static char getFromOrdinal(int ordinal) {
            return ChocoType.values()[ordinal].name().charAt(0);
        }
    }
}
