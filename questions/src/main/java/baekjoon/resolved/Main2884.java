package baekjoon.resolved;

import java.util.*;

public class Main2884 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2884
        https://www.acmicpc.net/source/50450639
        2022.10.12
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        if(m<45) {
            if(h==0) {
                h=23;
                m+=15;
            }
            else{
                h--;
                m+=15;
            }
        }
        else if(m==45) m=0;
        else if(m>45) m-=45;
        System.out.printf("%d %d",h,m);
    }
}