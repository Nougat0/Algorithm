package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main20218 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/20218
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> predict = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        //predicted
        for(int i=1; i<=n; i++) {
            predict.put(br.readLine(), i);
        }
        //final
        String fav = "";
        int diff = 0;
        for(int i=1; i<=n; i++) {
            String name = br.readLine();
            int order = predict.get(name);
            if(order - i > diff) {
                fav = name;
                diff = order - i;
            }
        }
        if(diff == 0) System.out.println("suspicious");
        else System.out.println(fav);
        br.close();
    }
}
