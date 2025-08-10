package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main22951 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/22951
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> cardNoList = new ArrayList<>();
        int[] cards = new int[n*k];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++) {
                cards[i*k + j] = Integer.parseInt(st.nextToken());
                cardNoList.add(i*k + j + 1); //1 ~ n*k
            }
        }
        int size = n*k;
        if(size > 1) {
            //index(0부터 시작) 와 번호(1부터 시작)가 섞여있어서 헷갈림...
            //index 사용할 때만 -1 넣어서 쓰자
            int cardNo = 1; //카드 순번 (1부터 시작)
            int cardNum; //카드에 쓰인 숫자
            int listNo; //cardNoList 순번
            int start; //시작카드의 cardNoList 순번
            while(size > 2) {
                cardNum = cards[cardNo-1]; //제거할 카드의 숫자 기록
                start = cardNoList.indexOf(cardNo); //기존카드 오른쪽 카드가 시작점이 됨 (같은 순번)
                cardNoList.remove((Integer) cardNo); //카드 제거

                listNo = (start + cardNum) % --size; //다음 시작 순번 (List 상 순번) 찾기
                cardNo = cardNoList.get(listNo == 0 ? size-1 : listNo-1); //다음 시작 카드 순번 꺼내기
            }
            cardNoList.remove((Integer) cardNo);
            cardNo = cardNoList.get(0); //마지막 남은 카드의 순번

            sb.append((cardNo -1) / k + 1).append(' ').append(cards[cardNo - 1]);
        } else { //사람 1명, 카드 1개일 경우
            sb.append(1).append(' ').append(cards[0]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
