package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13483 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        /** 입력 **/
        //사망일 입력 - 연월일 입력
        st = new StringTokenizer(br.readLine());
        int qualifiedDay = Integer.parseInt(st.nextToken());
        int qualifiedMonth = Integer.parseInt(st.nextToken());
        int qualifiedYear = Integer.parseInt(st.nextToken()) - 18; //만 18살이 될 수 있는 기준
        Birthday qualified = new Birthday(0, qualifiedYear, qualifiedMonth, qualifiedDay);
        //아들들 생일 입력 - 연월일 입력
        int sons = Integer.parseInt(br.readLine());
        List<Birthday> sonList = new ArrayList<>();
        for(int s=0; s<sons; s++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            sonList.add(new Birthday(s+1, year, month, day));
        }
        /** 연산 **/
        SucceedJudgement judgement = new SucceedJudgement(sons, sonList, qualified);
        int sonNumber = judgement.getQualified();
        bw.write(sonNumber + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class SucceedJudgement {
        int sons;
        List<Birthday> sonList;
        Birthday qualifiedDate;

        public SucceedJudgement(int sons, List<Birthday> sonList, Birthday qualifiedDate) {
            this.sons = sons;
            this.sonList = sonList;
            this.qualifiedDate = qualifiedDate;
        }

        public int birthdayComparator(Birthday o1, Birthday o2) {
            //return o1-o2 오름차순 (양수: o2부터, 음수: o1부터)
            if(o1.year > o2.year) return -1;
            else if(o1.year == o2.year)
                if(o1.month > o2.month) return -1;
                else if(o1.month == o2.month)
                    if(o1.day > o2.day) return -1;
                    else if(o1.day == o2.day) return 0;
            return 1;
        }

        public int getQualified() {
            //나이순 오름차순 정렬
            Collections.sort(sonList, (o1, o2) -> birthdayComparator(o1, o2));
            //적격자 선별
            int sonNumber = -1; //적격자 번호 초기화
            Birthday oldest = sonList.get(sons-1);
            Birthday youngest = sonList.get(0);
            boolean oldestQualified = birthdayComparator(oldest, qualifiedDate) >= 0;
            boolean youngestQualified = birthdayComparator(youngest, qualifiedDate) >= 0;
            //[1] 막내가 적격자일 경우 막내 선택
            if(youngestQualified) {
                sonNumber = youngest.number;
            }
            //[2] 막내가 부적격자, 맏이가 적격자일 경우
            //    가장 어린 적격자 찾기
            else if(oldestQualified) { //!youngestQualified
                for(int i=1; i<sons; i++) {
                    Birthday son = sonList.get(i);
                    if(birthdayComparator(son, qualifiedDate) >= 0) {
                        sonNumber = sonList.get(i).number;
                        break;
                    }
                }
            }
            //[3] 맏이가 부적격자일 경우 -1
            return sonNumber;
        }
    }

    public static class Birthday {
        int number;
        //생년월일
        int year;
        int month;
        int day;

        public Birthday(int number, int year, int month, int day) {
            this.number = number;
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}
