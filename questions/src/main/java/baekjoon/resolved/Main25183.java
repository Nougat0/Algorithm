package baekjoon.resolved;

import java.io.*;

public class Main25183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] lottery = br.readLine().toCharArray(); //65~90
        int adjacent = 0, maxAdjacent = 0;
        //문자열 각 char 값 뒷 순서와 검사
        for(int i=0; i<n-1 && maxAdjacent < 4; i++) { //당첨되었을 경우 뒷 문자열 추가검사 안해도 됨
            if(Math.abs(lottery[i]-lottery[i+1]) == 1) adjacent++;
            else adjacent = 0; //인접 초기화
            if(adjacent > maxAdjacent) maxAdjacent = adjacent; //최대인접값 갱신
        }
        //5개 연속 인접 = 인접여부는 4번까지만 확인해도 OK
        bw.write(maxAdjacent >= 4 ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }
}
