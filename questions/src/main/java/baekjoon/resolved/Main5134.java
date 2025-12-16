package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5134 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5134
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        for(int dataSet=1; dataSet<=k; dataSet++) {
            st = new StringTokenizer(br.readLine());
            int storeItems = Integer.parseInt(st.nextToken());
            int neededItems = Integer.parseInt(st.nextToken());

            int index = 0;
            Map<String, Integer> map = new HashMap<>();
            double[] discount = new double[storeItems];
            int[] amount = new int[storeItems];

            for(int i=0; i<storeItems; i++) {
                st = new StringTokenizer(br.readLine());
                int available = Integer.parseInt(st.nextToken());
                double price = Double.parseDouble(st.nextToken().substring(1));
                double salePrice = Double.parseDouble(st.nextToken().substring(1));
                StringBuilder name = new StringBuilder();
                while(st.hasMoreTokens()) {
                    name.append(st.nextToken()).append(" ");
                }
                //저장
                map.put(name.toString().toLowerCase(), index);
                discount[index] = price - salePrice;
                amount[index] = available;
                index++;
            }
            double saved = 0.0;
            for(int j=0; j<neededItems; j++) {
                st = new StringTokenizer(br.readLine());
                int needed = Integer.parseInt(st.nextToken());
                StringBuilder name = new StringBuilder();
                while(st.hasMoreTokens()) {
                    name.append(st.nextToken()).append(" ");
                }
                //비교 및 연산
                try {
                    index = map.get(name.toString().toLowerCase());
                } catch (NullPointerException e) {
                    continue;
                }
                saved += discount[index] * Math.min(needed, amount[index]);
            }
            sb.append("Data Set ").append(dataSet).append(":\n$");
            sb.append(String.format("%.2f", saved)).append("\n");
            if(dataSet < k-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
