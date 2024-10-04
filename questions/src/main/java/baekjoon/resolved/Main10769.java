package baekjoon.resolved;

import java.io.*;

public class Main10769 {
    public static final String isHappy = "happy";
    public static final String isSad = "sad";
    public static final String unsure = "unsure";
    public static final String none = "none";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] text = br.readLine().toCharArray();
        int length = text.length-2; //검사할 범위 = 맨 뒤에서 2번째 전까지
        int happy = 0, sad = 0;
        for(int i=0; i<length; i++)
            if(text[i] == ':' && text[i+1] == '-')
                if(text[i+2] == ')') happy++;
                else if(text[i+2] == '(') sad++;

        if(happy == 0 && sad == 0) bw.write(none); //이모티콘 없음
        else if(happy == sad) bw.write(unsure); //불확실
        else if(happy > sad) bw.write(isHappy); //행복
        else if(happy < sad) bw.write(isSad); //슬픔
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
