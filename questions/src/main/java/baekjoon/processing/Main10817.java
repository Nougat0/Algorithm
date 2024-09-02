package baekjoon.processing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++)
            list.add(Integer.parseInt(st.nextToken()));
        list.sort(null);
        //두번째로 큰 '숫자'가 아니라
        //일렬로 늘어놓았을 때 두 번째 자리의 수를 원하는 듯?
        bw.write(list.get(1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
