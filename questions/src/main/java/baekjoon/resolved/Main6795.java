package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int[] vars = new int[5]; //Nf, Nb, Bf, Bb, s -> Nf+Nb == loop, Bf+Bb == loop
        for(int i=0; i<5; i++) vars[i] = Integer.parseInt(br.readLine());
        //연산
        int lastLoop; //마지막 loop에서 진행된 step의 수
        int nikkyPosition = vars[4] / (vars[0] + vars[1]) * (vars[0] - vars[1]); //완료된 loop로 나아간 step의 수
        lastLoop = vars[4] % (vars[0] + vars[1]);
        nikkyPosition += lastLoop > vars[0]
                ? vars[0] - lastLoop % vars[0] //이미 앞으로 갈만큼 다 갔으므로 뒤로 가야 함
                : lastLoop; //앞으로 가는 중
        int byronPosition = vars[4] / (vars[2] + vars[3]) * (vars[2] - vars[3]); //완료된 loop로 나아간 step의 수
        lastLoop = vars[4] % (vars[2] + vars[3]);
        byronPosition += lastLoop > vars[2]
                ? vars[2] - lastLoop % vars[2] //이미 앞으로 갈만큼 다 갔으므로 뒤로 가야 함
                : lastLoop; //앞으로 가는 중
        //출력
        if(nikkyPosition == byronPosition) bw.write("Tied");
        else bw.write(nikkyPosition > byronPosition ? "Nikky" : "Byron");
        bw.flush();
        bw.close();
        br.close();
    }
}
