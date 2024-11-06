package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 
        //입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int[] lock = new int[n]; //자물쇠 수열
        boolean aligned = true; //자물쇠 불량 여부
        st = new StringTokenizer(br.readLine());
        Set<Integer> notAlignedItems = new HashSet<>(); //정렬되지 않은 시작점들
        for(int i=0; i<n; i++) {
            lock[i] = Integer.parseInt(st.nextToken());
            //정렬되지 않은 값들의 시작점 (교환가능 거리의 나머지값들)
            if(lock[i] != i) notAlignedItems.add(i%distance);
        }
        //연산
        if(notAlignedItems.size() > 0) { //정렬되지 않은 요소 존재 시
            EXIT_FOR:
            for(int notAlignedItem : notAlignedItems) {
                //교환가능 거리 간격의 값들(같은 나머지값) 정말 나머지값이 같은지 검사
                int index = notAlignedItem; //초기값 나머지
                while(index < n) {
                    //나머지값이 다를 시 불량 자물쇠
                    if(lock[index] % distance != notAlignedItem) {
                        aligned = false;
                        break EXIT_FOR;
                    }
                    //다음 검사할 index
                    index += distance;
                }
            }
        }
        //출력
        bw.write(aligned ? "Yes" : "No");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
