package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main13923 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13923
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<Integer> teamName;
        int[] teamCount;
        int[][] seats;
        /*
            이미 있는 팀의 알파벳 사용 VS 없는 팀의 알파벳 사용
            1) 개수가 1개 부족한 팀, 1개 더 많은 팀
            2) 개수가 1개 부족한 팀, 1개만 있는 팀
        */
        int cont = 0;
        String line;
        while((line = br.readLine()) != null) {
            cont++;
            int n = Integer.parseInt(line);

            teamName = new HashSet<>();
            teamCount = new int[26];
            seats = new int[n][n];

            //입력
            for(int i=0; i<n; i++) {
                line = br.readLine();
                for(int j=0; j<n; j++) {
                    int index = line.charAt(j) - 'A';
                    teamName.add(index);
                    teamCount[index]++;
                    seats[i][j] = index;
                }
            }

            int under = -1;
            int over = -1;
            boolean isOne = false;
            for(int i=0; i<26; i++) {
                if(teamCount[i] % n == n-1) under = i;
                if(teamCount[i] % n == 1) {
                    isOne = teamCount[i] == 1;
                    over = i;
                }
            }

            char alphabet = (char) (under + 'A');
            int overRow = -1;
            int overCol = -1;
            for(int i=0; i<n; i++) {
                int rowCount = 0;
                int colCount = 0;
                for(int j=0; j<n; j++) {
                    if(seats[i][j] == over) {
                        if(isOne) {
                            overRow = i;
                            overCol = j;
                        } else {
                            if(rowCount == 1) overRow = i;
                            if(colCount == 1) overCol = j;
                        }
                        rowCount++;
                        colCount++;
                    }
                }
            }
            sb.append(overRow+1).append(' ')
                    .append(overCol+1).append(' ')
                    .append(alphabet).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
