package baekjoon.resolved;

import java.util.*;

public class Main25501 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25501
        https://www.acmicpc.net/source/69971143
        2023.12.03
    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int idx=0; idx<t; idx++) System.out.println(isPalindrome(sc.next()));
    }

    public static String recursion(String s, int l, int r, int count){
        if(l >= r) return "1 "+count;
        else if(s.charAt(l) != s.charAt(r)) return "0 "+count;
        else return recursion(s, l+1, r-1, count+1);
    }
    public static String isPalindrome(String s){
        return recursion(s, 0, s.length()-1, 1);
    }
}