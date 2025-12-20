package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18294 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18294
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> index = new HashMap<>();
        Map<Integer, String> names = new HashMap<>();
        int[] species = new int[n];
        // 등장하는 개체 종류가 정해지지 않아서
        // 최악의 경우를 가장해서 n 사용
        int speciesCount = 0;
        for(int i=0; i<n; i++) {
            String name = br.readLine();
            Integer speciesIndex = index.get(name);
            if(speciesIndex == null) {
                species[speciesCount]++;
                names.put(speciesCount, name);
                index.put(name, speciesCount++);
            } else {
                species[speciesIndex]++;
            }
        }
        //과반수를 차지하는 개체가 있는지 확인
        int overtake = -1;
        for(int i=0; i<speciesCount; i++) {
            if(species[i] > n/2) {
                overtake = i;
                break;
            }
        }
        String result = overtake > -1 ? names.get(overtake) : "NONE";
        System.out.println(result);
        br.close();
    }
}
