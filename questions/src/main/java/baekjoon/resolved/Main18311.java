package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main18311 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18311
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int doubleN = n * 2;
        int courseCount = doubleN + 1;
        long[] course = new long[courseCount];
        //0부터 코스 채F우기
        st = new StringTokenizer(br.readLine());
        long accumDistance = 0;
        int distance;
        for(int i=0; i<n; i++) {
            distance = Integer.parseInt(st.nextToken());
            course[i + 1] = (accumDistance += distance);
            int pairIndex = doubleN - (i + 1);
            if(pairIndex < courseCount && pairIndex != (i + 1)) {
                course[pairIndex] -= accumDistance;
            }
        }
        for(int i=n+1; i<courseCount; i++) {
            course[i] += accumDistance * 2;
        }

        int courseIndex = binarySearch(course, k);
        int courseNo = -1;
        switch(courseIndex / n) {
            case 0: courseNo = courseIndex + 1; break;
            case 1: courseNo = doubleN - courseIndex; break;
        }
        System.out.println(courseNo);
        br.close();
    }

    /**
     * 현재 위치한 course의 index 찾기
     * 이진탐색으로 구현
     * @param arr
     * @param value
     * @return index
     */
    public static int binarySearch(long[] arr, long value) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;
        long midValue;
        /**
         * 두 index 의 사잇값일 수 있기 때문에 left/right Index 조정 시 +1, -1은 제외함
         * (midIndex 재사용 필요)
         */
        while((leftIndex + 1) < rightIndex) {
            midIndex = (leftIndex + rightIndex) / 2;
            midValue = arr[midIndex];
            if(midValue == value) return midIndex;
            else if(midValue < value) leftIndex = midIndex;
            else if(midValue > value) rightIndex = midIndex;
        }
        return leftIndex;
    }
}
