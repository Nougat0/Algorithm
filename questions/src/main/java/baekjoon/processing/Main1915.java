package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1915 {
    /*
        12345
        22345
        33345
        44445
        55555

        입력된 배열 값이 전부 1이라고 가정했을 때,
        사각형 한 변의 길이가 N 일 때 확인하면 되는 칸들을 표시해봄
        (예: 한 변의 길이가 3인 정사각형이 존재하는지 확인할 때는
        길이 1, 2 에서 이미 체크된 칸 바로 바깥의 5개 칸만 확인하면 됨)
        위의 예시는 (1,1) 칸을 기준으로 정사각형이 존재하는지 확인함

        굳이 N*N 칸을 모두 확인할 필요가 없지만,
        한 변의 길이 1부터 오름차순으로 확인해야 함 (Bottom-Up)

        12345
        22345
        33345
        44045
        55555

        위의 경우, 길이 4 정사각형 확인절차에서 0이 발견되어 길이 4인 정사각형은 존재하지 않게 됨
        -> 길이가 3인 정사각형까지 존재하게 된다

        각 길이 체크 때마다 전체 n*n 개를 모두 순회할 필요없이,
        n-1 크기에서 이미 확인된 정사각형 바깥의 칸만 체크하면 됨

        ================================================================

        직접 떠올린 위 방식은 2가지 단점이 존재하며, 이로 인해 시간초과가 뜸
        1. 사각형 크기가 커질수록 검색해야 할 범위도 넓어진다 (한 변의 길이*2)
        2. 모든 유효한 좌표별로 연산을 따로 해줘야 하는 단점 존재 (이전 연산값 재활용 못함)

        그래서 찾아보니 정반대의 방식으로 DP를 사용할 수 있다
        (https://breakcoding.tistory.com/366 설명 방식 참고)
        - 기존방식: 왼쪽 위 꼭짓점 기준
        - 찾은방식: 오른쪽 아래 꼭짓점 기준
            - 2*2 범위만 항상 검색하면 됨 (1번 단점 상쇄)
            - 이전에 연산한 사각형 최대크기를 활용하여 해당 좌표의 최대크기 연산 가능 (2번 단점 상쇄)
        11111
        12222
        12333
        12344
        12345

    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] maxLengthValues = new int[n+1][m+1]; //각 좌표(오른쪽 아래 꼭짓점)별로 사각형 최대길이값 저장용 (DP)
        int maxLengthOfCoord; //해당 좌표의 사각형 최대길이값
        int maxLength = 0;
        boolean filled;
        //입력받으면서 동시에 maxLength DP 값 연산해서 저장
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                //1: true, 0: false
                filled = line.charAt(j) == '1';
                if(filled) {
                    //2*2 범위 탐색, 최소값+1 도출
                    maxLengthOfCoord = Math.min(Math.min(maxLengthValues[i][j], maxLengthValues[i+1][j]), maxLengthValues[i][j+1]) + 1;
                } else {
                    //사각형이 되지 못하므로 무조건 0
                    maxLengthOfCoord = 0;
                }
                //최대값 갱신하기
                if(maxLength < maxLengthOfCoord) maxLength = maxLengthOfCoord;
                maxLengthValues[i+1][j+1] = maxLength;
            }
        }
        //출력
        bw.write(maxLength*maxLength + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
