package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<String> mailList = new ArrayList<>();
        int mailCnt = Integer.parseInt(br.readLine());
        for(int m=0; m<mailCnt; m++) {
            st = new StringTokenizer(br.readLine(), "@");
            //정규식으로 @ 앞의 문자에 있는 . 과 +(뒤에 따라오는 문자 포함) 을 제거하고 비교
            String uniqueUser = st.nextToken().replaceAll("\\.|\\+.*", "") + "@" + st.nextToken();
            if(mailList.indexOf(uniqueUser) == -1) {
                mailList.add(uniqueUser);
            }
        }
        bw.write(mailList.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
