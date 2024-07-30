package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        StringTokenizer st;
        int studentCount = Integer.parseInt(br.readLine());
        int[][] classNo = new int[studentCount][5]; //학생수*5개학년
        int[] friendCount = new int[studentCount];
        for(int i=0; i<studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++)
                classNo[i][j] = Integer.parseInt(st.nextToken());
        }

        //연산
        int studentNo = 0;
        int maxFriends = 0;
        for(int i=0; i<studentCount; i++) {//i 학생과
            for(int k=0; k<studentCount; k++) {//k 학생과
                if(i==k) continue;
                boolean haveMet = false;
                for(int j=0; j<5; j++) //학년 통틀어 만났는지
                    if(haveMet) break;
                    else if(classNo[i][j] == classNo[k][j]) {
                        haveMet = true;
                        friendCount[i]++; //i 학생의 친구수++
                    }
            }
            if(friendCount[i] > maxFriends) { //최고 인기쟁이 선발
                studentNo = i;
                maxFriends = friendCount[i];
            }
        }

        //출력
        bw.write((studentNo+1)+"\n"); //1번부터 시작이므로 +1
        bw.flush();
        bw.close();
        br.close();
    }
}
