package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int neverHeard = Integer.parseInt(st.nextToken()); //듣도 못한 사람 수
        int neverSeen = Integer.parseInt(st.nextToken()); //보도 못한 사람 수
        TreeSet<String> neverKnown = new TreeSet<>(); //듣보잡 목록

        TreeSet<String> neverHeardMap = new TreeSet<>(); //듣도 못한 사람 목록
        for(int i=0; i<neverHeard; i++)
            neverHeardMap.add(br.readLine());

        for(int i=0; i<neverSeen; i++) { //듣도 못한 사람들 보도 못한 사람들과 대조
            String name = br.readLine();
            if(neverHeardMap.contains(name))
                neverKnown.add(name);
        }

        //neverKnown.sort(Comparator.naturalOrder()); //알파벳순 정렬
        bw.write(neverKnown.size() + "\n"); //듣보잡 개수 출력
        for(String name : neverKnown) { //듣보잡 하나씩 출력
            bw.write(name);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
