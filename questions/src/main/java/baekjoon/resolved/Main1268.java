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
        boolean[][] friendList = new boolean[studentCount][studentCount]; //학생수*학생수
        for(int i=0; i<studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++)
                classNo[i][j] = Integer.parseInt(st.nextToken());
        }

        //연산
        for(int i=0; i<studentCount; i++) {//i 학생의
            for (int j = 0; j < 5; j++)  //j+1 학년 때
                //같은 반이었던 사람 있는지 확인
                for (int k = 0; k < studentCount; k++)  //k 학생과 같은 반이었는가?
                    if (i != k && classNo[i][j] == classNo[k][j]) //본인 제외
                        friendList[i][k] = true;
        }
        //친구수 세기
        int studentNo = 0;
        int friendCount = 0;
        for(int i=0; i<studentCount; i++) { //각 학생의
            int count = 0;
            for(int j=0; j<studentCount; j++) //친구 수 세기
                if(friendList[i][j]) count++;
            if(friendCount < count) {//최고 인기쟁이 갱신조건
                //번호는 오름차순이므로 제어완료, 친구수로만 확인
                studentNo = i;
                friendCount = count;
            }
        }
        //1번부터 시작이므로 +1
        bw.write((studentNo+1)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
