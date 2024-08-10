package baekjoon.processing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        사실상 시 부분에 올 숫자만 제약사항이 있고, 그 외의 분, 초는 입력값 모든 범위가 유효함
        따라서 시가 될 수 있는지만 확인해서 count

        모든 숫자 자리 6곳에는 0~9까지의 숫자가 올 수 있음...
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int count = 0;
        int[] time = new int[3];
        for(int i=0; i<3; i++) //입력
            time[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<3; i++) {
            //확인할 위치정보 arrayList 로 가지고 있기
            List<Integer> index = new ArrayList<>() {{add(0);add(1);add(2);}};
            if(time[i] > 0 && time[i] <= 12) { //시 체크
                index.remove(i);
                for (int j=0; j<2; j++) { //시를 제외한 나머지 칸들 확인
                    if (time[index.get(j)] >= 0 && time[index.get(j)] < 60) { //분 체크
                        int sec = j==0 ? 1 : 0;
                        if (time[sec] >= 0 && time[sec] < 60) { //초 체크
                            count++;
                        }
                    }
                }
            }
        }
        //출력
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
