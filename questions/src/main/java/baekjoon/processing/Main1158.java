package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> circle = new ArrayList<>();
        List<Integer> printList = new ArrayList<>();
        for(int i=1; i<=n; i++) circle.add(i);

        /*
        3칸 이동X
        3번 이동O
         */
        int cursor = -1;
        while(!circle.isEmpty()) {
            if(cursor + k > circle.size() - 1) {
                while(cursor + k > circle.size() - 1) {
                    cursor = (cursor + k) - (circle.size());
                }
            }
            else cursor = cursor + k;
            System.out.println(circle.get(cursor));
            circle.remove(cursor);
            cursor--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
