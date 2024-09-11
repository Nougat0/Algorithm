package baekjoon.processing;

import java.io.*;

public class Main2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while(!(input = br.readLine()).equals("#")) {
            int appearance = 0;
            char alphabet = input.charAt(0);
            char[] sentence = input.substring(2).toLowerCase().toCharArray();
            for(char letter : sentence) {
                if(letter == alphabet)
                    appearance++;
            }
            bw.write(String.format("%c %d", alphabet, appearance));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
