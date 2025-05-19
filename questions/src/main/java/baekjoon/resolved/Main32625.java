package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32625 {
    /*
        https://www.acmicpc.net/problem/32625
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int MIN_INIT = 100_000;
    public static final int MAX_INIT = 0;
    public static final int SUM_INIT = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int min = MIN_INIT;
        int max = MAX_INIT;
        int value;
        for(int i=0; i<n; i++) {
            value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            if(value < min) min = value;
            if(value > max) max = value;
        }
        boolean possible = false;
        if(min == max) {
            possible = true;
        } else {
            //모든 구간의 크기는 같다 = 구간의 크기는 나누어떨어져야 한다 = 약수만 가능
            //약수 구하기
            double squareRoot = Math.sqrt(n);
            Set<Integer> divisorSet1 = new HashSet<>();
            Set<Integer> divisorSet2 = new HashSet<>();
            for(int length=2; length<=squareRoot; length++) {
                if(n % length == 0) divisorSet1.add(length);
            }
            for(Integer length : divisorSet1) divisorSet2.add(n / length);
            divisorSet1.addAll(divisorSet2);
            //구간(약수)별 최대값 최소값 구하기
            for(Integer length : divisorSet1) {
                int loop, index;
                int pastMinMaxSum = SUM_INIT;
                for(loop=0, possible=true; loop<n/length; loop++) {
                    for(index=loop*length, min=MIN_INIT, max=MAX_INIT; index<(loop+1)*length; index++) {
                        if(arr[index] > max) max = arr[index];
                        if(arr[index] < min) min = arr[index];
                    }
                    if(pastMinMaxSum == SUM_INIT) { //최초값 없을 시 채우기
                        pastMinMaxSum = min + max;
                    } else if(pastMinMaxSum != (min + max)){ //최초값 있으면 비교하기
                        possible = false;
                        break;
                    }
                }
                if(possible) break; //이미 가능한 구간 존재 확인 완료
            }
        }
        System.out.println(possible ? 1 : 0);
        br.close();
    }
}
