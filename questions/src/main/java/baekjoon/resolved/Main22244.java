package baekjoon.resolved;

import java.io.*;

public class Main22244 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/22244
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            String line = br.readLine();
            int day = getNum(line.charAt(0)) * 10 + getNum(line.charAt(1));
            int month = getNum(line.charAt(2)) * 10 + getNum(line.charAt(3));
            int year = Integer.parseInt(line.substring(4, 7));
            year += year >= 600 ? 1000 : 2000;
            int author = getNum(line.charAt(7));
            int control = getNum(line.charAt(8));

            boolean isValid =
                    isCorrectDate(day, month, year)
                    && isCorrectAuthor(author)
                    && isCorrectControl(line, control);
            sb.append(isValid ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getNum(char c) {
        return c - '0';
    }

    private static boolean isLeapYear(int year) {
        return !(year % 100 == 0 && year % 400 != 0) && (year % 4 == 0);
    }

    private static boolean isCorrectDate(int day, int month, int year) {
        if(month == 0 || month > 12) return false; //month 최소, 최대
        else if(day == 0) return false; //day 최소
        else { //day 최대
            switch(month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(day > 31) return false;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(day > 30) return false;
                    break;
                case 2:
                    int max = isLeapYear(year) ? 29 : 28;
                    if(day > max) return false;
                    break;
            }
            return true;
        }
    }

    private static boolean isCorrectAuthor(int author) {
        return (author == 1 || author == 6 || author == 9);
    }

    private static boolean isCorrectControl(String line, int control) {
        int sum = 0;
        for(int i=0; i<8; i++) {
            int num = getNum(line.charAt(i));
            sum += (num * num);
        }
        return sum % 7 == control;
    }
}
