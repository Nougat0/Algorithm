package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main2783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 + 1000g 가격 연산
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        double[] priceList = new double[n+1];

        //세븐25
        priceList[0] = Double.parseDouble(st.nextToken()) * 1000 / Double.parseDouble(st.nextToken());
        //편의점 체인점들
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            priceList[i] = Double.parseDouble(st.nextToken()) * 1000 / Double.parseDouble(st.nextToken());
        }

        //최소금액 확인
        double minPrice = 100000; //최대값으로 초기화
        for(double price: priceList) 
            if(minPrice > price) minPrice = price;

        bw.write(String.format("%.2f%n", minPrice));
        bw.flush();
        bw.close();
        br.close();
    }
}
