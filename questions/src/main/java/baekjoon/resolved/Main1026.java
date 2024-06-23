package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int n = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) b.add(Integer.parseInt(st.nextToken()));

        /*
          연산
          b가 작은 순서대로 a의 값을 역순으로 매칭되도록 배치 (a최대값 -> b최소값, a최소값 -> b최대값)
          최종적으로 S 값만 출력하면 되니 a, b 순서는 신경 X
        */
        int s = 0;
        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.reverseOrder());
        for(int i=0; i<n; i++) s += a.get(i)*b.get(i);

        //출력
        bw.write(s+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
