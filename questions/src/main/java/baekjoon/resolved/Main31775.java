package baekjoon.resolved;

import java.io.*;

public class Main31775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean hasK = false, hasL = false, hasP = false;
        char[] letters = new char[3];
        //입력 및 연산
        for(int i=0; i<3; i++) {
            letters[i] = br.readLine().charAt(0);
            if(letters[i] == 'l') hasL = true;
            else if(letters[i] == 'k') hasK = true;
            else if(letters[i] == 'p') hasP = true;
        }
        boolean isGlobal = hasK && hasL && hasP;
        //출력
        bw.write(isGlobal ? "GLOBAL" : "PONIX");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
