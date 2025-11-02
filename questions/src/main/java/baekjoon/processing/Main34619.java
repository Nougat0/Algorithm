import java.io.*;
import java.util.*;

public class Main34619 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34619
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int platoon = n/c + (n%c == 0 ? 0 : 1); //소대 번호
        int company = platoon/b + (platoon%b == 0 ? 0 : 1); //중대 번호
        
        System.out.println(company + " " + platoon);
        br.close();
    }
}