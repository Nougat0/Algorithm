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
        
        int platoon = n/c + (n%c == 0 ? 0 : 1); //전체 소대 순서
        int companyNo = platoon/b + (platoon%b == 0 ? 0 : 1); //중대 번호
        int platoonNo = platoon%b == 0 ? b : platoon%b; //소대 번호
        
        System.out.println(companyNo + " " + platoonNo);
        br.close();
    }
}