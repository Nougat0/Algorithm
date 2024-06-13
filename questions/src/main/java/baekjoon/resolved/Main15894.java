package baekjoon.resolved;

import java.util.*;

public class Main15894 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        //둘레 길이는 정사각형과 같다 - n값만 생각하고 n*4는 int 범위 벗어나는 걸 간과했다..
        System.out.println(4*n);
        sc.close();
    }
}
