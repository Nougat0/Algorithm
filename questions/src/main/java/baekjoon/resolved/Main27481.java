package baekjoon.resolved;

import java.io.*;

public class Main27481 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력
        int n = Integer.parseInt(br.readLine());
        boolean[] rooms = new boolean[10];
        char[] customers = br.readLine().toCharArray();
        //연산
        for(int c=0; c<n; c++)
            //왼쪽부터 들어가기
            if(customers[c] == 'L') {
                for(int i=0; i<10; i++)
                    if(!rooms[i]) {
                        rooms[i] = true;
                        break;
                    }
            } //오른쪽부터 들어가기
            else if(customers[c] == 'R') {
                for(int i=9; i>=0; i--)
                    if(!rooms[i]) {
                        rooms[i] = true;
                        break;
                    }
            } //방 번호의 손님 나감
            else rooms[Character.getNumericValue(customers[c])] = false;
        //출력
        for(int i=0; i<10; i++) sb.append(rooms[i] ? 1 : 0);
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
