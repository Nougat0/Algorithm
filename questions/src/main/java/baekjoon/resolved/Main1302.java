package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> soldBookList = new HashMap<>();
        //책 입력
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String book = br.readLine();
            if(soldBookList.containsKey(book)) {
                soldBookList.put(book, soldBookList.get(book)+1);
            } else {
                soldBookList.put(book, 1);
            }
        }
        //가장 많이 팔린 책 확인
        Map.Entry<String, Integer> maxSold = null;
        for(Map.Entry<String, Integer> soldBook : soldBookList.entrySet())
            if(maxSold == null || //첫 값일 경우
               soldBook.getValue().compareTo(maxSold.getValue()) > 0 || //팔린 갯수가 더 많을 경우
               (soldBook.getValue().compareTo(maxSold.getValue()) == 0 && soldBook.getKey().compareTo(maxSold.getKey()) < 0) //팔린 개수는 동일하고 알파벳 우선순위일 경우
            ) maxSold = soldBook;
        bw.write(maxSold.getKey() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
