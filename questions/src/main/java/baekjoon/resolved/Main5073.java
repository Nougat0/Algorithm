package baekjoon.resolved;
import java.io.*;
import java.util.*;

public class Main5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean hasNext = true;
        int[] side = new int[3];
        /**
         * 3개 변 받기
         */
        while(hasNext) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) {
                side[i] = Integer.parseInt(st.nextToken());
            }

            if(side[0] == 0) hasNext = false;
            else if (checkValid(side)) {
                if(side[0] == side[1] && side[1] == side[2])
                    bw.write("Equilateral\n");
                else if(side[0] == side[1] || side[1] == side[2] || side[0] == side[2])
                    bw.write("Isosceles\n");
                else //3개 다 다르다
                    bw.write("Scalene\n");
            } else
                bw.write("Invalid\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 유효한 삼각형인지 확인
     * @param sides
     * @return
     */
    public static boolean checkValid(int[] sides){
        int sum = 0, max = 0;
        for (int side : sides){
            sum += side;
            if (side > max) max = side;
        }
        //sum 값은 max 2배보다 커야 한다
        if(sum - 2*max > 0) return true;
        else return false;
    }
}