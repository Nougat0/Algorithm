package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //입력
        int[][] dots = new int[3][2];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }
        //출력
        Triangle tri = new Triangle(dots);
        bw.write(tri.evaluate());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 삼각형 클래스
     * 삼각형의 세 좌표, 선, 각도를 통해 삼각형의 종류 도출
     */
    public static class Triangle {
        int[][] vertex; //꼭지점 좌표
        int[] side; //(변 길이)^2
        double[] slope; //변 기울기
        Integer[] angle; //각도

        public Triangle(int[][] vertex) {
            this.vertex = vertex; //좌표는 밖에서 입력받은 걸 받아온다
            this.side = new int[3];
            this.slope = new double[3];
            this.angle = new Integer[3];
            this.getSidesNAngles();
            this.getSlopes();
        }

        /**
         * side(변의 길이)와 angle(내각) 구하기
         * angle은 side를 구한 뒤 구해야 해서 하나의 함수로 묶음
         */
        public void getSidesNAngles() {
            int i, j, index;
            //side 구하기
            for(i=0, index=0; i<3-1; i++) {
                for(j=i+1; j<3; j++) {
                    int a = vertex[j][0] - vertex[i][0]; //x축과 평행한 변
                    int b = vertex[j][1] - vertex[i][1]; //y축과 평행한 변
                    //부동소수점 때문에 해당 변의 길이(X) => 제곱 길이(O) 사용
                    side[index++] = /*Math.sqrt*/(a*a + b*b);
                }
            }
            //angle 구하기
            for(i=0, index=0; i<3-1; i++) {
                for(j=i+1; j<3; j++) {
                    double a = side[i];
                    double b = side[j];
                    double c = side[2-index];
                    int value = 100;
                    if(a + b == c) { //직각
                        value = 0;
                    } else if(a + b < c) { //둔각
                        value = 1;
                    } else if(a + b > c) { //예각
                        value = -1;
                    }
                    angle[index++] = value;
                }
            }
            //가장 큰 각이 앞에 오도록 정렬
            Arrays.sort(angle, Collections.reverseOrder());
        }

        /**
         * slope(변의 길이) 구하기
         */
        public void getSlopes() {
            int index = 0;
            for(int i=0; i<3-1; i++) {
                for(int j=i+1; j<3; j++) {
                    slope[index++] = (vertex[j][0] - vertex[i][0]) /
                            (double) (vertex[j][1] - vertex[i][1]);
                }
            }
        }

        /**
         * 삼각형의 종류 구하기 (각도 최대값을 통해)
         * 각도 배열은 내림차순으로 정렬되어 있음을 가정하고 진행
         * @return
         */
        public String evaluateAngle() {
            switch(angle[0]) {
                case 0: return "Jikkak";
                case 1: return "Dunkak";
                default: return "Yeahkak";
            }
        }

        /**
         * 삼각형의 종류 구하기 (각도 최대값 + 변의 길이를 통해)
         * @return
         */
        public String evaluate() {
            StringBuilder sb = new StringBuilder();
            /*세 점이 일직선에 있으면 (기울기가 같으면)*/
            if(slope[0] == slope[1] && slope[1] == slope[2]) {
                return new StringBuilder("X").toString();
            }
            /*세 변의 길이가 같으면*/
            if(side[0] == side[1] && side[1] == side[2]) {
                sb.append("Jung");
            }
            /*두 변의 길이가 같으면*/
            else if(side[0] == side[1] || side[1] == side[2] || side[2] == side[0]) {
                sb.append(evaluateAngle()).append(2);
            }
            /*변의 길이가 전부 다르면*/
            else if(side[0] != side[1] && side[1] != side[2]){
                sb.append(evaluateAngle());
            }
            return sb.append("Triangle").toString();
        }
    }
}
