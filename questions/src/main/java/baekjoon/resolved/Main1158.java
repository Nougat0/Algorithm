package baekjoon.resolved;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
            cursor += k;
            if(cursor > circle.size() - 1) {
                while(cursor > circle.size() - 1) {
                    cursor -= circle.size();
                }
            }
            printList.add(circle.get(cursor));
            circle.remove(cursor);
            cursor--;
        }
        bw.write(String.format("<%s>%n",
                printList.stream().map(Object::toString)
                .collect(Collectors.joining(", "))));
        bw.flush();
        bw.close();
        br.close();
    }
}
