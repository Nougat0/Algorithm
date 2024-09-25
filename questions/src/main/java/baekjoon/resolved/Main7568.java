package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //입력
        int peopleCnt = Integer.parseInt(br.readLine());
        List<Build> buildList = new ArrayList<>(); //덩치 저장할 List
        int[] rank = new int[peopleCnt]; //덩치 등수 저장할 배열
        for(int i=0; i<peopleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            buildList.add(
                new Build(
                    Integer.parseInt(st.nextToken()), //kg
                    Integer.parseInt(st.nextToken()) //cm
                ));
        }
        //등수 계산
        for(int i=0; i<peopleCnt; i++) {
            //다른 사람과 덩치 비교
            for(int j=0; j<peopleCnt; j++) {
                if(i==j) continue;
                if(buildList.get(j).biggerThan(buildList.get(i)))
                    rank[i]++; //덩치가 더 큰 사람이 있을 경우 랭크 밀림
            }
            sb.append(rank[i]+1); //집계된 [덩치가 더 큰 사람 수] + 1 = 덩치 순위
            if(i != peopleCnt-1) sb.append(" "); //순위 사이 공백
        }
        //출력
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 덩치 객체
     */
    public static class Build {
        int weight; //몸무게 (kg)
        int height; //키 (cm)

        public Build(int weight, int height) { //생성자
            this.weight = weight;
            this.height = height;
        }

        /**
         * 덩치 비교
         * @param build 비교할 덩치
         * @return 비교대상 build보다 덩치가 클 경우 true,
         * 덩치가 작거나 비교할 수 없는 경우 false
         */
        boolean biggerThan(Build build) {
            if(this.weight > build.weight && this.height > build.height) return true;
            else return false;
        }
    }
}

