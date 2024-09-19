package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1524 {
    public static final String juneWins = "S";
    public static final String beeWins = "B";
    public static final String draw = "C";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        List<Integer> juneArmy = new ArrayList<>();
        List<Integer> beeArmy = new ArrayList<>();
        StringTokenizer army;
        for(int t=0; t<testCase; t++) {
            br.readLine(); //testCase 간의 구분줄
            br.readLine(); //병사 수 안 사용함
            //StringTokenizer armyCnt = new StringTokenizer(br.readLine()); //안 사용함
            //int n = Integer.parseInt(armyCnt.nextToken());
            //int m = Integer.parseInt(armyCnt.nextToken());
            army = new StringTokenizer(br.readLine());
            while(army.hasMoreTokens()) juneArmy.add(Integer.parseInt(army.nextToken()));
            army = new StringTokenizer(br.readLine());
            while(army.hasMoreTokens()) beeArmy.add(Integer.parseInt(army.nextToken()));

            //약한 병사를 선두로 정렬
            juneArmy.sort(Comparator.naturalOrder());
            beeArmy.sort(Comparator.naturalOrder());

            String result;
            while((result = clash(juneArmy, beeArmy)) == null) {}
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 전투 진행, 진행 전 승부가 났는지 확인함
     * @param juneArmy 세준의 군대
     * @param beeArmy 세비의 군대
     * @return 전쟁의 최종승부를 반환한다.<br>
     * 승부가 나지 않았을 경우 null, 세비가 이겼을 경우 B, 세준이 이겼을 경우 S, 비겼을 경우 C
     */
    public static String clash(List<Integer> juneArmy, List<Integer> beeArmy) {
        //전쟁 승부가 났는지 확인
        if(juneArmy.isEmpty() && beeArmy.isEmpty())
            return draw;
        else if(beeArmy.isEmpty()) {
            juneArmy.clear();
            return juneWins;
        } else if(juneArmy.isEmpty()) {
            beeArmy.clear();
            return beeWins;
        }
        //전투에 참여할 병사 선출
        int juneSoldier = juneArmy.get(0);
        int beeSoldier = beeArmy.get(0);
        //전투
        if(juneSoldier == beeSoldier)
            beeArmy.remove(0);
        else if(juneSoldier > beeSoldier)
            beeArmy.remove(0);
        else if(juneSoldier < beeSoldier)
            juneArmy.remove(0);
        return null; //전쟁은 여전히 진행중이다
    }
}
