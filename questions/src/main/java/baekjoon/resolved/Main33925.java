package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33925 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33925
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int maxJump = Integer.parseInt(st.nextToken());
        int maxSlides = Integer.parseInt(st.nextToken());
        int health = Integer.parseInt(st.nextToken());
        int damage = Integer.parseInt(st.nextToken());

        String top = br.readLine();
        String mid = br.readLine();
        String btm = br.readLine();

        int jumps = 0;
        int doubleJumps = 0;
        int slides = 0;
        for(int i=0; i<length; i++) {
            char m = mid.charAt(i);
            char b = btm.charAt(i);

            if(m == '^') doubleJumps++;
            else if(m == 'v') slides++;
            else if(b == '^') jumps++;
        }

        int damaged = 0;
        // [1] 점프개수 비교
        //     장애물 종류에 상관없이 damage는 같으니, 필요 시 더블점프 때 점프하지 않기
        if(maxJump < (jumps + doubleJumps * 2)) {
            if(jumps > maxJump) {
                damaged += (jumps - maxJump + doubleJumps);
            } else if(jumps < maxJump){
                int remains = maxJump - jumps;
                damaged += (doubleJumps - remains/2);
            } else {
                damaged += doubleJumps;
            }
        }

        // [2] 슬라이드 개수 비교
        if(maxSlides < slides) {
            damaged += (slides - maxSlides);
        }

        //결과 출력
        int result = health - damaged * damage;
        if(result <= 0) result = -1;
        System.out.println(result);
        br.close();
    }
}
