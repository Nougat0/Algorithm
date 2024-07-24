package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1350 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int fileCount = Integer.parseInt(br.readLine()); //미사용
        br.readLine();
        StringTokenizer fileSizes = new StringTokenizer(br.readLine());
        int clusterSize = Integer.parseInt(br.readLine());
        long usedDiskSize = 0L;
        while(fileSizes.hasMoreTokens()) {
            double fileSize = Double.parseDouble(fileSizes.nextToken());
            usedDiskSize += (long) Math.ceil(fileSize/clusterSize) * clusterSize;
        }
        bw.write(usedDiskSize + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
