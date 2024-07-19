package baekjoon.resolved;

import java.io.*;

public class Main1296 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String yeondu = br.readLine(); //연두 이름
        int nameCnt = Integer.parseInt(br.readLine()); //후보 이름 갯수
        String[] nameList = new String[nameCnt+1]; //후보 이름 목록 (0은 연두)
        nameList[0] = yeondu;
        int[][] nameScore = new int[nameCnt+1][5]; //후보 이름 연산을 위한 이중배열 (0은 연두)
        char[] alphabet = new char[] {'L', 'O', 'V', 'E'}; //연산 알파벳 배열

        //연두 연산
        for(int i=0; i<alphabet.length; i++)
            nameScore[0][i] = getAlphabetCount(yeondu, alphabet[i]);

        //팀 이름 입력 + 연산
        for(int i=1; i<=nameCnt; i++) {
            nameList[i] = br.readLine();
            nameScore[i][4] = 1; //초기값 0이라서 곱셈 시 값 반영 X, 1로 초기화
            for(int j=0; j<alphabet.length; j++)
                nameScore[i][j] = nameScore[0][j] + getAlphabetCount(nameList[i], alphabet[j]);
            //공식 적용
            for(int j=0; j<alphabet.length-1; j++)
                for(int k=j+1; k<4; k++)
                    nameScore[i][4] *= (nameScore[i][j] + nameScore[i][k]);

            nameScore[i][4] %= 100;
        }

        int teamNumber = 1;
        //출력할 팀 이름 구하기
        for(int i=2; i<=nameCnt; i++) { //0은 연두 이름, 1은 초기값, 2부터 비교
            if(nameScore[i][4] > nameScore[teamNumber][4])
                //점수가 더 높은 것 채택
                teamNumber = i;
            else if(nameScore[i][4] == nameScore[teamNumber][4] && nameList[i].compareTo(nameList[teamNumber]) < 0)
                //같은 점수일 경우 compareTo 로 사전 비교
                teamNumber = i;
        }

        bw.write(nameList[teamNumber] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getAlphabetCount(String name, char alphabet) {
        int count = 0;
        for(int i=0; i<name.length(); i++)
            if(name.charAt(i) == alphabet) count++;
        return count;
    }
}
