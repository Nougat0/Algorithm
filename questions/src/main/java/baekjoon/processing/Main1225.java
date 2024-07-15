package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        long sum = 0;
        for(int i=0; i<a.length; i++)
            for(int j=0; j<b.length; j++)
                sum += Character.getNumericValue(a[i]) * Character.getNumericValue(b[j]);

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
