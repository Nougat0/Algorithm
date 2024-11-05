package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main32373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] lock = new int[n]; //자물쇠 수열
        boolean[] itemsAligned = new boolean[n]; //각 숫자가 오름차순 정렬되었는지 확인
        boolean aligned = true; //자물쇠 불량 여부
        int distance = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            lock[i] = Integer.parseInt(st.nextToken());
            itemsAligned[i] = lock[i] == i;
        }
        //연산
        for(int i=0; i<n; i++)
            if(!itemsAligned[i])
                //윗 번호나 아래 번호와 바꿔서 정렬이 되지 않을 경우
                if(!(i+distance < n && lock[i+distance] == i || i-distance >= 0 && lock[i-distance] == i)) {
                    aligned = false;
                    break;
                }
        //출력
        bw.write(aligned ? "Yes" : "No");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
