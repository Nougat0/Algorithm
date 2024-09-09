package baekjoon.processing;

import java.io.*;

public class Main1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alphabet = new int[26]; //97~122
        int frequentNo = 0; //가장 빈번하게 등장하는 횟수
        String line;
        //입력 + 수 세기
        while((line = br.readLine()) != null) {
            line = line.replaceAll(" ", "");
            char[] alphabets = line.toCharArray();
            for(char letter : alphabets) {
                alphabet[letter - 97]++;
                if(alphabet[letter - 97] > frequentNo)
                    frequentNo = alphabet[letter - 97];
            }
        }
        //출력
        for(int i=0; i<alphabet.length; i++) {
            if(alphabet[i] == frequentNo)
                bw.write(String.valueOf((char) (i + 97)));
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
