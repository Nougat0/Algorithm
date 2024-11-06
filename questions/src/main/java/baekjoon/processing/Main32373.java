package baekjoon.processing;

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
        List<Integer> notAlignedItems = new ArrayList<>(); //정렬되지 않은 시작점들
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            lock[i] = Integer.parseInt(st.nextToken());
            //정렬되지 않은 값들의 시작점 (교환가능 거리의 나머지값들)
            if(lock[i] != i && notAlignedItems.indexOf(i%distance) == -1)
                notAlignedItems.add(i%distance);
        }

        if(notAlignedItems.size() > 0) { //정렬되지 않은 요소 존재 시
            List<Integer> newLockArr;
            EXIT_FOR:
            for(int notAlignedItem : notAlignedItems) {
                //교환가능 거리 간격의 값들(같은 나머지값)을 새로운 수열로 가져오기
                newLockArr = new ArrayList<>();
                for(int i=0; i<=n/distance && i*distance + notAlignedItem <n; i++)
                    newLockArr.add(lock[i*distance + notAlignedItem]);
                Collections.sort(newLockArr); //오름차순 정렬
                //새로운 수열의 element 값들 간의 간격이 교환가능 거리와 일치하는지 확인
                for(int i=0; i<n/distance-1; i++) {
                    if(newLockArr.get(i+1) - newLockArr.get(i) != distance) {
                        //일치하지 않을 경우 바로 불량품 판정
                        aligned = false;
                        break EXIT_FOR;
                    }
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
