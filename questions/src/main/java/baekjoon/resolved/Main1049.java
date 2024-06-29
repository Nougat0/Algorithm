package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n,m;
        /*
        꼭 6개 맞춰 살 필요 없음 (초과구매 가능)
        꼭 같은 브랜드에서 6개/낱개 함께 살 필요 없음 (각자 다른 브랜드꺼 사도 됨)
        최소가격이 되어야 할 것

        그렇다면 가장 싼 6개, 낱개 가격만 가져다가 조합하면 될 듯
         */
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] price = new int[] { 1000, 1000 }; //나올 수 없는 수로 초기화

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            price[0] = Math.min(price[0], Integer.parseInt(st.nextToken())); //6줄 패키지 가격의 최소값 담기
            price[1] = Math.min(price[1], Integer.parseInt(st.nextToken())); //1줄 낱개 가격의 최소값 담기
        }

        int minValue = (n/6 + 1) * price[0]; //나올 수 없는 수로 최소값 초기화
        //6줄 패키지의 갯수에 따른 최소값 확인
        for(int i=0; i<= n/6 + 1; i++) {
            boolean needsSingleString = 6*i < n; //낱개 계산이 필요한 경우 확인
            minValue = Math.min(minValue, ((price[0] * i) + (needsSingleString ? ( n - 6*i ) * price[1] : 0)));
        }

        bw.write(minValue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
