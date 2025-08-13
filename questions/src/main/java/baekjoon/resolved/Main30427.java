package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30427 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30427
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> suspects = new ArrayList<>();
        Set<String> cleared = new HashSet<>();
        br.readLine();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) suspects.add(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) cleared.add(br.readLine());
        
        suspects.add("swi"); //본인도 용의자에 포함
        if(suspects.contains("dongho")) System.out.println("dongho");
        else {
            //목격담이 있는 사람 제외
            cleared.forEach(person -> {
                if(suspects.contains(person)) suspects.remove(person);
            });
            
            if(suspects.size() == 1) System.out.println(suspects.get(0)); //swi 가 범인
            else if(suspects.contains("bumin")) System.out.println("bumin");
            else if(suspects.contains("cake")) System.out.println("cake");
            else if(suspects.contains("lawyer")) System.out.println("lawyer");
            else {
                suspects.remove("swi");
                suspects.sort(String::compareTo);
                System.out.println(suspects.get(0));
            }
        }
        br.close();
    }
}
