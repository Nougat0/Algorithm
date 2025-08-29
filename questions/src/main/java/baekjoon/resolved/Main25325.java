package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25325 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25325
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] count = new int[n]; //호감표시 개수 기록용 목록
        Integer[] indexes = new Integer[n]; //index 목록 (정렬용)
        Map<String, Integer> list = new HashMap<>(); //(이름, index) 목록
        String[] names = new String[n]; //(index, 이름) 목록

        //이름 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            String name = st.nextToken();
            list.put(name, i);
            names[i] = name;
            indexes[i] = i;
        }

        //호감 정보 입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String name = st.nextToken();
                count[list.get(name)]++;
            }
        }
        
        //정렬
        Arrays.sort(indexes, (i1, i2) -> {
            int compareResult = Integer.compare(count[i2], count[i1]);
            if(compareResult == 0) { //같은 값일 시 알파벳 비교 --> 오름차순 정렬
                return names[i1].compareTo(names[i2]);
            } else { //내림차순 정렬
                return compareResult;
            }
        });

        //출력
        for(int i=0; i<n; i++) {
            int index = indexes[i];
            sb.append(names[index]).append(" ").append(count[index]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
