package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int acheDays = 0;
        int days = Integer.parseInt(st.nextToken());
        int acheStart = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Stress stress = new Stress(acheStart);
        while(st.hasMoreTokens()) {
            if(stress.stressAche(Integer.parseInt(st.nextToken()))) {
                acheDays++;
            }
        }
        bw.write(acheDays + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Stress {
        int value; //스트레스 총량
        int acheStart; //배앓이하는 스트레스 최소량

        public Stress(int acheStart) {
            this.value = 0; //초기값 0
            this.acheStart = acheStart;
        }

        /**
         * 스트레스 변화로 복통을 앓는지 확인
         * @param change 스트레스 변화량
         * @return 복통을 앓는 경우 true, 아닐 경우 false
         */
        boolean stressAche(int change) {
            //0이하로 내려가지 않게 조절
            if((this.value += change) <= 0) {
                this.value = 0;
            }
            return (this.value >= acheStart);
        }
    }
}
