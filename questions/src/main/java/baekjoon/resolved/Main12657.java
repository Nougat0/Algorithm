package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12657 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/12657
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            sb.append("Case #").append(i).append(":\n");
            //input
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            Land land = new Land(height, width);

            for(int h=0; h<height; h++) {
                st = new StringTokenizer(br.readLine());
                for(int w=0; w<width; w++) {
                    int altitude = Integer.parseInt(st.nextToken());
                    land.setAltitude(h, w, altitude);
                }
            }
            //process
            sb.append(land.process());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public enum Direction {
        NORTH (-1, 0), WEST(0, -1), EAST(0, 1), SOUTH(1, 0);

        private final int h;
        private final int w;

        Direction(int h, int w) {
            this.h = h;
            this.w = w;
        }
        public int getH() {
            return h;
        }
        public int getW() {
            return w;
        }
    }

    public static class Land {
        private int height;
        private int width;
        private int[][] land;
        private Map<Integer, Integer> sinks;
        private int sinkCount;

        public Land(int height, int width) {
            this.height = height;
            this.width = width;
            this.land = new int[height][width];
            this.sinks = new HashMap<>();
            this.sinkCount = 0;
        }

        public void setAltitude(int h, int w, int altitude) {
            this.land[h][w] = altitude;
        }

        public StringBuilder process() {
            StringBuilder landMap = new StringBuilder();
            for(int h=0; h<height; h++) {
                for(int w=0; w<width; w++) {
                    landMap
                        .append((char) (followStream(h, w) + 'a'))
                        .append(" ");
                }
                landMap.append("\n");
            }
            return landMap;
        }

        /**
         * 최종 흘러가는 곳으로 가보기
         * @param h
         * @param w
         */
        private int followStream(int h, int w) {
            int lowest = land[h][w];
            Direction minDir = null;
            for(Direction dir : Direction.values()) {
                int altitude = 11;
                int hIndex = h + dir.getH();
                int wIndex = w + dir.getW();
                if(hIndex >= 0 && hIndex < height && wIndex >= 0 && wIndex < width) {
                    altitude = land[hIndex][wIndex];
                }
                if(lowest > altitude) {
                    minDir = dir;
                    lowest = altitude;
                }
            }

            if(minDir == null) {
                //현재 위치가 가장 낮은 위치, 혹은 주변 altitude 모두 동일
                int position = h*height + w;
                if(sinks.containsKey(position)) {
                    //기존 sink 사용
                    return sinks.get(position);
                } else {
                    //새로운 sink 발견
                    sinks.put(position, sinkCount);
                    return sinkCount++;
                }
            } else {
                return followStream(h + minDir.getH(), w + minDir.getW());
            }
        }
    }
}
