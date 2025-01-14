package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int date, change, recordCnt = Integer.parseInt(br.readLine());
        Record[] changedDays = new Record[100];
        char cow;
        //입력
        for(int i=0; i<recordCnt; i++) {
            st = new StringTokenizer(br.readLine());
            date = Integer.parseInt(st.nextToken())-1; //날짜
            cow = st.nextToken().charAt(0); //소(첫글자 약칭)
            change = Integer.parseInt(st.nextToken()); //생산량 변동값
            //기록 저장
            changedDays[date] = new Record(cow, change);
        }
        Display display = new Display();

        int countChanges = 0;
        //변화 추적
        for(int i=0; i<100; i++) {
            Record record = null;
            //빈칸 건너뛰기
            while(i<99 && (record = changedDays[i]) == null) i++;
            //1위 변경 있을 시 +1
            if(record != null && display.addRecord(record)) {
                countChanges++;
            }
        }
        bw.write(countChanges + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 농부 John 의 기록 (일별)
     */
    public static class Record {
        char cow; //'M', 'E', 'B'
        int change; //변화값
        public Record(char cow, int change) {
            this.cow = cow;
            this.change = change;
        }
    }

    /**
     * 소들의 정보 기록용 클래스
     */
    public static class Cow {
        char name; //이름(첫글자 약칭)
        int milkProduce; //우유 생산량
        boolean displayed; //디스플레이에 보여지는지 여부

        public Cow(char name) {
            this.name = name;
            this.milkProduce = 7;
            this.displayed = true; //초반 모두 공동1위
        }
    }

    /**
     * 우유 생산량 1위 표시용 디스플레이
     */
    public static class Display {
        Cow[] current; //현재 소들의 정보

        public Display() {
            this.current = new Cow[] {new Cow('B'), new Cow('E'), new Cow('M')};
        }

        /**
         * 기록을 현재 생산량에 반영
         * @param record 기록
         */
        boolean addRecord(Record record) {
            for(int i=0; i<current.length; i++) {
                //기록에 해당하는 소 찾아서 생산량 갱신
                if(current[i].name == record.cow) {
                    current[i].milkProduce += record.change;
                    break;
                }
            }
            sortDesc(); //생산량 많은 순서로 재정렬
            return update(); //디스플레이 표시여부 생산량 확인하여 갱신
        }

        /**
         * 내림차순 정렬
         */
        void sortDesc() {
            for(int i=0; i<current.length; i++) {
                for(int j=i+1; j<current.length; j++) {
                    if(current[j].milkProduce > current[i].milkProduce) {
                        Cow temp = current[i];
                        current[i] = current[j];
                        current[j] = temp;
                    }
                }
            }
        }

        /**
         * 변경된 생산량 기반으로
         * 디스플레이 표시여부 업데이트
         * @return 표시여부 달라지면 true, 전부 일치하면 false
         */
        boolean update() {
            int maxProduce = current[0].milkProduce;
            boolean changed = false;
            for(int i=0; i<current.length; i++) {
                boolean shouldBeDisplayed = current[i].milkProduce == maxProduce;
                //디스플레이 변동 여부 확인
                //이미 디스플레이 갈아끼워야 하면 굳이 추가로 확인하지 않아도 됨
                //생산량 최대달성(미표시) or 생산량 N등(N>=2) 표시
                if(!changed && (current[i].displayed != shouldBeDisplayed)) {
                    changed = true;
                }
                //변경여부와 달리 표시 갱신
                current[i].displayed = shouldBeDisplayed;
            }
            return changed;
        }
    }
}
