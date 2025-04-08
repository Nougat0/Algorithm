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
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] sequence = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                //1: true, 0: false
                sequence[i][j] = line.charAt(j) == '1';
            }
        }
        //연산, 출력
        Sequence seq = new Sequence(n, m, sequence);
        int maxLength = seq.getMaxSquare();
        bw.write(maxLength*maxLength + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 좌표 저장용 클래스 구현
     * 정사각형의 왼쪽 위 꼭지점 좌표 저장용
     */
    public static class Coordinate {
        int y, x;
        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    /**
     * 배열 저장, 정사각형 최대 크기 구하는 클래스 구현
     */
    public static class Sequence {
        int n, m, maxLength; //배열크기 행의 수, 열의 수, 더 큰 값
        boolean[][] sequence; //입력받은 배열
        boolean squareExist; //length(인덱스)의 정사각형 존재유무
        Set<Coordinate> list; //length(인덱스)의 정사각형을 이룬 왼쪽 위 꼭지점 목록

        public Sequence(int n, int m, boolean[][] sequence) {
            this.n = n; //행
            this.m = m; //열
            this.sequence = sequence; //배열 (n*m)
            maxLength = Math.max(n, m);
            squareExist = false;
            list = new HashSet<>();
        }

        /**
         * 가장 큰 정사각형의 한 변의 길이 반환
         * @return
         */
        public int getMaxSquare() {
            //길이 1 먼저 체크 (확인 로직이 다름)
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    if(sequence[i][j]) {
                        squareExist = true;
                        list.add(new Coordinate(i, j));
                    }
            // 길이 2 -> maxLength 까지 정사각형 순차 체크
            int maxSquareLength = 1;
            for(int l=2; l<=maxLength && squareExist; l++) {
                squareExist = false; //이번 길이 체크 초기화

                Iterator<Coordinate> iterator = list.iterator();
                //이전 크기 정사각형들 꼭지점 순환
                while(iterator.hasNext()) {
                    Coordinate coord = iterator.next();
                    boolean isSquare = true;
                    int yMax = coord.y + l - 1;
                    int xMax = coord.x + l - 1;
                    if(yMax >= n || xMax >= m) {
                        continue; //배열 범위 초과
                    }
                    //이번 크기의 오른쪽 끝, 아래 끝 한 줄씩 체크
                    for(int i=0; i<l && isSquare; i++)
                        isSquare = isSquare && sequence[coord.y + i][xMax - 1] && sequence[yMax - 1][coord.x + i];
                    isSquare = isSquare && sequence[yMax][xMax];

                    if(isSquare) { //정사각형이 맞을 경우
                        squareExist = true;
                    } else { //이번 길이에서 해당 좌표는 정사각형 아님
                        iterator.remove();
                    }
                }
                //이번 길이에서 정사각형이 있었으면 최대값 갱신
                if(squareExist) {
                    maxSquareLength = l;
                }
            }
            return maxSquareLength;
        }
    }
}
