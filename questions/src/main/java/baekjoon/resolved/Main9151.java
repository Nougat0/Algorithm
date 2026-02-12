package baekjoon.resolved;

import java.io.*;

public class Main9151 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9151
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StarShip ship = new StarShip();
        int n;
        while((n = Integer.parseInt(br.readLine())) > 0) {
            sb.append(ship.getRequest(n)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class StarShip {
        private int[] cubic;
        private int[] tetrahedral;
        public StarShip() {
            this.cubic = new int[55];
            this.tetrahedral = new int[97];

            //개별적으로 사용 가능한 값 먼저 계산
            for(int i=1; i<97; i++) {
                tetrahedral[i] = i*(i+1)*(i+2)/6;
                if(i < 55) {
                    cubic[i] = i*i*i;
                }
            }
        }

        public int getRequest(int offer) {
            int resultA, resultB, resultAB;
            int idxA, idxB;
            idxA = binarySearch(cubic, offer);
            idxB = binarySearch(tetrahedral, offer);
            int idx, sum, max = 0;
            for(int c=1; c<=idxA; c++) {
                idx = binarySearch(tetrahedral, offer - cubic[c]);
                sum = cubic[c] + tetrahedral[idx];
                if(sum > max) {
                    max = sum;
                }
            }
            resultA = cubic[idxA];
            resultB = tetrahedral[idxB];
            resultAB = max; //둘 다 혼합은 brute force로 구함

            return Math.max(Math.max(resultA, resultB), resultAB);
        }

        /**
         * 이진탐색으로 offer 값이 arr에서 최대 어느 부분을 만족하는지 확인
         * @param arr
         * @param offer
         * @return
         */
        private int binarySearch(int[] arr, int offer) {
            int left = 0;
            int right = arr.length - 1;
            int mid, midValue;

            while(left < right) {
                mid = (left + right) / 2;
                midValue = arr[mid];

                if(midValue <= offer && arr[mid+1] > offer) return mid;
                else if(arr[mid+1] <= offer) left = mid;
                else if(midValue > offer) right = mid;
            }
            return left;
        }
    }
}
