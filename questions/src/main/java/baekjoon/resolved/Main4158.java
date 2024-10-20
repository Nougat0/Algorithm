package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cds = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if(cds[0]==0 && cds[1]==0) break;
            //각자 갖고 있는 CD 번호 입력 및 대조
            int sameCDs = 0;
            List<Integer> listOfCDs = new ArrayList<>();
            for(int i=0; i<cds[0]; i++) listOfCDs.add(Integer.parseInt(br.readLine()));
            for(int i=0; i<cds[1]; i++)
                if(contains(listOfCDs, Integer.parseInt(br.readLine())))
                    sameCDs++; //같이 갖고 있는 CD
            bw.write(sameCDs + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 첫번째 CD목록에 두번째 목록의 CD가 존재하는지 확인
     * @param list 첫번째 CD목록
     * @param cdNo 두번째 목록의 CD (1개)
     * @return
     */
    public static boolean contains(List<Integer> list, int cdNo) {
        //이분탐색 구현
        int left = 0; //왼쪽 끝
        int right = list.size() - 1; //오른쪽 끝

        while(left <= right) {
            int mid = left + (right -left) /2; //가운데 인덱스 계산
            int midCdNo = list.get(mid); //가운데 CD 번호
            //반으로 나눠서 탐색
            if(midCdNo == cdNo)  return true; //가운데 번호일 경우
            else if(midCdNo < cdNo) left = mid + 1; //가운데 CD 번호보다 클 경우 왼쪽 끝을 mid+1로 지정 
            else right = mid - 1; //가운데 CD 번호보다 작을 경우 오른쪽 끝을 mid-1로 지정
        }
        return false;
    }
}
