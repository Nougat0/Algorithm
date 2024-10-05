package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int savedSites = Integer.parseInt(st.nextToken());
        int findingSites = Integer.parseInt(st.nextToken());
        Map<String, String> password = new HashMap<>(); //사이트, 비밀번호
        for(int i=0; i<savedSites; i++) { //저장된 각 사이트와 비밀번호
            st = new StringTokenizer(br.readLine());
            password.put(st.nextToken(), st.nextToken());
        }
        for(int i=0; i<findingSites; i++) { //비밀번호 찾을 사이트
            bw.write(password.get(br.readLine()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
