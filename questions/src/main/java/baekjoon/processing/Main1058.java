package baekjoon.processing;

import java.io.*;

public class Main1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] friendList = new char[n][n];
        for(int i=0; i<n; i++) friendList[i] = br.readLine().toCharArray();

        int max2Friend = 0;
        for(int i=0; i<n; i++) {
            int twoFriend = 0;
            for(int j=i+1; j<n; j++) {
                if(friendList[i][j] == 'Y') twoFriend++;
                else {
                    for(int k=0; k<n; k++)
                        if(friendList[k][i] == 'Y' && friendList[k][j] == 'Y')
                            twoFriend++;

                }
            }
            if(twoFriend > max2Friend)
                max2Friend = twoFriend;
        }

        bw.write(max2Friend + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
