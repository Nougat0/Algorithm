package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cards = new ArrayList<>();
        for(int i=0; i<n; i++) cards.add(Integer.parseInt(st.nextToken()));
        int index = 0; //찾기 시작할 위치
        int number = 1; //찾을 제자리 수
        int skip = 0; //삭제한(건너뛴) 숫자의 수
        while(true) {
            int prevIndex = index;
            if((index = indexOf(number, index, cards)) == -1) {
                //다음 찾을 제자리수가 없을 때 -- 남은 숫자 모두 제거, 종료
                skip += cards.size() - prevIndex;
                break;
            } else {
                //다음 제자리수 찾음 -- 사이 숫자 모두 제거
                skip += (index - prevIndex);
                number++; //다음 찾을 숫자
                index++; //찾은 위치 다음부터 다음 숫자 찾기
            }
        }
        bw.write(skip + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 기존 List.indexOf 는 찾을 범위 지정을 할 수 없으므로
     * 시작위치를 사용하는 indexOf 직접 정의해서 새용
     * @param o list에서 찾을 대상
     * @param fromIndex 찾기 시작할 list 위치
     * @param list
     * @return 못 찾으면 -1, 찾으면 list 에서의 위치
     */
    public static int indexOf(Object o, int fromIndex, List list) {
        int indexOfSublist = list.subList(fromIndex, list.size()).indexOf(o);
        if(indexOfSublist != -1) indexOfSublist += fromIndex; //기존 list에서의 index 값으로 맞추기
        return indexOfSublist;
    }
}
