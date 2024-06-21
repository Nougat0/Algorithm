package baekjoon.processing;

import java.io.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Main1010 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(String.format("시작 %s",new Timestamp(System.currentTimeMillis())));
        //입력
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            //맨 위에 몰리기 -> 맨 아래에 몰리기(순서는 유지)
            //맨 밑의 것이 한 칸씩 아래로 내려갈 때마다 경우의 수 세기
            //m = n+1 -> n+1가지 경우
            //결국 m개 중에 n개 선택하는 경우의 수 구하기임
            //맨 밑의 점의 위치에 따라 나머지 점들 배치
            //모든 점들은 밑의 점 위치에 따라 자리 제약이 있음
            bw.write(String.format("%d시작 %s%n", (i+1), new Timestamp(System.currentTimeMillis())));
            //경우의 수이기 때문에 for문 안에서 할 것은 별로 없다... 그냥 곱하기 연산 하면 될 듯
            int count = countRecursive(1, n, m, 0);
            /*
            첫번째(j) 점: n ~ m
            두번째(k) 점: n-1 ~ j-1 (첫번째 점의 경우에 따라 각각 계산)
            세번째(l) 점: n-2 ~ k-1 (두번째 점의 경우에 따라 각각 계산)
            p번째 점 : n-p+1 ~ (이전 점)-1 (p번째 점의 경우에 따라 각각 계산)
             */
            /*
            a개 : b개
            oooooxxxx
            j=a  --> nmlkjxxxx -> 1,1,1,1
                k=a-1  --> nmlkxxxxx -> 1,1,1
                k=a    --> nmlxkxxxx -> 1,1,2
                k=a+1  --> nmlxxkxxx -> 1,1,3
            j=a+1 -> nmlkxjxxx -> 1,1,1,2
            j=a+2 -> nmlkxxjxx -> 1,1,1,3
            j=a+1 -> nmlkxjxxx -> 1,1,1,2
            j=a+1 -> nmlkxjxxx -> 1,1,1,2

            어우
            2개 : 5개
            j=2 --> kjxxx -> 1
            j=3 --> kxjxx -> 2
            j=4 --> kxxjx -> 3
            j=5 --> kxxxj -> 4

            어우
            3개 : 5개
            j==3 --> lkjxx -> k=1
                k==2 --> lkjxx -> l=1
            j==4 --> lkxjx -> k=2
                k==2 --> lkxjx -> l=1
                k==3 --> lxkjx -> l=2
            j==5 --> lkxxj -> k=3
                k==2 --> lkxxj -> l=1
                k==3 --> lxkxj -> l=2
                k==4 --> lxxkj -> l=3

            어우
            3개 : 6개
            j==3 --> lkjxxx -> k=1
                k==2 --> lkjxxx -> l=1
            ---------------------------------1
            j==4 --> lkxjxx -> k=2
                k==2 --> lkxjxx -> l=1
                k==3 --> lxkjxx -> l=2
            ---------------------------------1+2
            j==5 --> lkxxjx -> k=3
                k==2 --> lkxxjx -> l=1
                k==3 --> lxkxjx -> l=2
                k==4 --> lxxkjx -> l=3
            ---------------------------------1+2+3
            j==6 --> lkxxxj -> k=3
                k==2 --> lkxxxj -> l=1
                k==3 --> lxkxxj -> l=2
                k==4 --> lxxkxj -> l=3
                k==5 --> lxxxkj -> l=4
            ---------------------------------1+2+3+4

            a개 횟수만큼 재귀 depth 가 결정되고
            b만큼 for문 반복횟수가 많아짐
            
            for(int j=3; j<=6; j++) { --> for(int j=a-depth+1; j<b-depth+1; j++)
                for(int k=3-1; k<=j-1; k++){
                    for(int l=3-2; l<=k-1; l++) {
                        최종 depth 에서 count++ --> if(depth == a)
                    }
                }
            }
             */
            bw.write(String.format("%d%n", count));
            bw.write(String.format("%d끝 %s%n", (i+1), new Timestamp(System.currentTimeMillis())));
        }
        bw.write(String.format("끝 %s%n", new Timestamp(System.currentTimeMillis())));

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 가장 바깥에 점이 하나 더 있다고 가정하기 (m+1)
     * @param depth
     * @param n n은 모든 재귀함수에서 동일하게 갖고 있어야 함
     * @param m 다음 재귀 for문 최대값
     * @param count
     * @return
     */
    public static int countRecursive(int depth, int n, int m, int count) throws IOException {
//        bw.write(String.format("[ %d-%d-%d :: 시작 ]%n", depth, n, m));
        int depthCount = 0;
        boolean finalDepth = depth == n;
        if(finalDepth)
            count += (m- (n-depth+1) +1);
        else
            for(int i=n-depth+1; i<=m; i++) {
//                bw.write(String.format("%d--%d%n", depth, i));
                depthCount += countRecursive(depth+1, n, i-1, count);
            }

//        bw.write(String.format("[ %d-%d-%d :: 끝 ]%n", depth, n, m));
        return count + depthCount;
    }
    /*
    3개 : 6개
    n=3, m=6
    ---------------------------------
    j==3 --> lkjxxx
        k==2 --> lkjxxx -> l=1
	    l=1 --> lkjxxx
    ---------------------------------1
    j==4 --> lkxjxx
        k==2 --> lkxjxx -> l=1
	    l=1 --> lkxjxx
        k==3 --> lxkjxx -> l=2
	    l=1 --> lxkjxx
	    l=2 --> xlkjxx
    ---------------------------------1+2
    j==5 --> lkxxjx
        k==2 --> lkxxjx
	    l=1 --> lkxxjx
        k==3 --> lxkxjx -> l=2
	    l=1 --> lxkxjx
	    l=2 --> xlkxjx
        k==4 --> lxxkjx -> l=3
	    l=1 --> lxxkjx
	    l=2 --> xlxkjx
	    l=3 --> xxlkjx
    ---------------------------------1+2+3
    j==6 --> lkxxxj
        k==2 --> lkxxxj
	    l=1 --> lkxxxj
        k==3 --> lxkxxj
	    l=1 --> lxkxxj
	    l=2 --> xlkxxj
        k==4 --> lxxkxj -> l=3
	    l=1 --> lxxkxj
	    l=2 --> xlxkxj
	    l=3 --> xxlkxj
        k==5 --> lxxxkj -> l=4
	    l=1 --> lxxxkj
	    l=2 --> xlxxkj
	    l=3 --> xxlxkj
	    l=4 --> xxxlkj
    ---------------------------------1+2+3+4
     */
}
