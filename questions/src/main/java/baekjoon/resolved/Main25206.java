package baekjoon.resolved;

import java.util.*;
import java.io.*;

public class Main25206 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25206
        https://www.acmicpc.net/source/78452767
        2024.05.17
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //학점별 점수 미리 맵핑하여 사용
        Map<String, Double> gradeGrid = Map.of(
                "A+", 4.5,
                "A0", 4.0,
                "B+", 3.5,
                "B0", 3.0,
                "C+", 2.5,
                "C0", 2.0,
                "D+", 1.5,
                "D0", 1.0,
                "F", 0.0,
                "P", -1.0
        );
        double pointTotal = 0;
        double pointAndGradeTotal = 0;

        //과목별로 점수와 등급 계산
        for(int i=0; i<20; i++) {
            String[] line = br.readLine().split(" ");
            double point = Double.parseDouble(line[1]); //학점
            double grade = gradeGrid.get(line[2]); //등급

            if(grade == -1.0) {//P등급일 경우 계산하지 않음
                continue;
            } else {
                pointTotal += point;
                pointAndGradeTotal += point*grade;
            }
        }

        System.out.println(pointAndGradeTotal / pointTotal);
        br.close();
    }
}
