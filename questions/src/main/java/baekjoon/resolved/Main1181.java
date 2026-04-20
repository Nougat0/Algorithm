package baekjoon.resolved;

import java.util.*;
import java.io.*;

public class Main1181 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1181
        https://www.acmicpc.net/source/62060886
        2023.06.14
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] list = new String[n];
        for(int i=0;i<n;i++) list[i] = br.readLine();

        //길이순 정렬 로직 + 길이가 같으면 어휘순 정렬 로직
        for(int j=0; j<n;j++) {
            for(int i=j+1;i<n;i++) {
                String temp = new String();
                String former = list[j];
                String latter = list[i];
                if(former.length() > latter.length()) {
                    temp = former;
                    list[j] = latter;
                    list[i] = temp;
                } else if(former.length() == latter.length()) {
                    if(former.compareTo(latter) > 0){
                        temp = former;
                        list[j] = latter;
                        list[i] = temp;
                    } else if(former.compareTo(latter) == 0){
                        list[j] = "";
                    }
                }
            }
        }
        for(String s: list)
            if(s != "") System.out.println(s);
        br.close();
    }
}