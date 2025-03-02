package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31800 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Product> prodList = new ArrayList<>();
        //이익 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int profit = Integer.parseInt(st.nextToken());
            Product prod = new Product(i, profit);
            prodList.add(prod);
        }
        //가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int price = Integer.parseInt(st.nextToken());
            prodList.get(i).setPrice(price);
        }
        //기회비용 연산
        //이익 기준 내림차순 정렬
        Collections.sort(prodList, (o1, o2) -> o2.getProfit() - o1.getProfit());
        //1) 이익이 제일 큰 물건만 먼저 연산
        prodList.get(0).setCost(prodList.get(1).getProfit() - prodList.get(0).getPrice());
        int maxProfit = prodList.get(0).getProfit();
        //2) 나머지 물건들 연산
        for(int i=1; i<n; i++) {
            Product product = prodList.get(i);
            product.setCost(maxProfit - product.getPrice());
        }
        //순수익 연산 및 출력
        StringBuilder sb = new StringBuilder();
        //index 기준으로 오름차순 정렬
        Collections.sort(prodList, Comparator.comparingInt(Product::getIndex));
        for(int i=0; i<n; i++) {
            Product product = prodList.get(i);
            int netProfit = product.calcNetProfit();
            sb.append(netProfit).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 구매제품 클래스
     */
    public static class Product{
        private int index; //순번 (입력순서)
        private int profit; //이익
        private int price; //가격
        private int cost; //기회 비용

        public Product(int index, int profit) {
            this.index = index;
            this.profit = profit;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int calcNetProfit() {
            return this.profit - this.price - this.cost;
        }
    }
}
