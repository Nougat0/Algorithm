package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31908 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31908
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final int N = Integer.parseInt(br.readLine());
        Map<String, String> ringWithNames = new HashMap<>();
        Set<String> multipleRings = new HashSet<>();
        //입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            if(!ring.equals("-")) { //반지가 있을 경우에만
                ringWithNames.compute(ring, (key, val) -> {
                    if(val == null) { //1명
                        return name;
                    } else { //2명++
                        multipleRings.add(ring);
                        return val.concat(" "+name);
                    }
                });
            }
        }
        //커플 구분
        int coupleCount = 0;
        StringBuilder couples = new StringBuilder();
        Iterator<String> rings = multipleRings.iterator();
        while(rings.hasNext()) {
            String ring = rings.next();
            int nameCount = 1;
            String names = ringWithNames.get(ring);
            int length = names.length();
            for(int i=0; i<length && nameCount < 3; i++) {
                if(names.charAt(i) == ' ') nameCount++;
            }
            if(nameCount == 2) {
                coupleCount++;
                couples.append(names).append("\n");
            }
        }
        sb.append(coupleCount).append("\n").append(couples);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
