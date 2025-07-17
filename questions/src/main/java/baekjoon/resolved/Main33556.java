package baekjoon.resolved;

import java.io.*;

public class Main33556 {
    /*
        https://www.acmicpc.net/problem/33556
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String a = br.readLine();
        String b = br.readLine();
        //직접 구현해보기
        if(equals(a,"null")) { //앞이 null
            System.out.println("NullPointerException");
            System.out.println("NullPointerException");
        } else if(equals(b, "null")) { //앞이 문자열, 뒤가 null
            System.out.println(false);
            System.out.println(false);
        } else { //앞, 뒤 모두 문자열
            System.out.println(equals(a, b));
            System.out.println(equalsIgnoreCase(a, b));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //String.equals(String) 직접 구현해보기
    public static boolean equals(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        //예외조건들 확인
        if(aLength != bLength) return false;
        else {
            for(int i=0; i<aLength; i++) {
                if(a.charAt(i) != b.charAt(i)) return false;
            }
        }
        return true;
    }
    //String.equalsIgnoreCase(String) 직접 구현해보기
    public static boolean equalsIgnoreCase(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        //예외조건들 확인
        if(aLength != bLength) return false;
        else {
            for(int i=0; i<aLength; i++) {
                char aAtIndex = a.charAt(i);
                char bAtIndex = b.charAt(i);
                //전부 uppercase로 바꿔서 비교
                if(aAtIndex >= 'a' && aAtIndex <= 'z') aAtIndex -= ('a'-'A');
                if(bAtIndex >= 'a' && bAtIndex <= 'z') bAtIndex -= ('a'-'A');
                if(aAtIndex != bAtIndex) return false;
            }
        }
        return true;
    }
}
