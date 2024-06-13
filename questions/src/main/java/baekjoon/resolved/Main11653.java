package baekjoon.resolved;

import java.io.*;

public class Main11653 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        while(n > 1) {
            for(int i=2; i<=n; i++) {
                if(n % i == 0) {
                    bw.write(String.format("%d%n", i));
                    n /= i;
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //어떤 분이 계속 도전하심 (hyeongu02)
    //시도1
    //14880	152
    public static void take1(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        int N=Integer.parseInt(br.readLine());
        int tmp=N;
        while(N>0) {
            for(int i=2;i<=tmp;i++) {
                if(N%i==0) {
                    N/=i;
                    sb.append(i).append('\n');
                    break;
                }
            }
            if(N==1)break;
        }
        System.out.println(sb);
    }

    //시도2
    //14352	128
    public static void take2(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        int N=Integer.parseInt(br.readLine());
        int tmp=N;
        for(int i=2;i*i<=tmp;i++) {
            while(N%i==0) {
                sb.append(i).append('\n');
                N/=i;
            }
        }
        if(N!=1) sb.append(N);
        System.out.println(sb);
    }

    //시도4 (3은 큰 차이 없었음)
    //14376	124
    public static void take4(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }
        if (N != 1) {
            sb.append(N);
        }
        System.out.println(sb);
    }

    //시도5
    //14300	104
    public static void take5(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        int N=Integer.parseInt(br.readLine());
        for(int i=2;i*i<=N;i++) {
            while(N%i==0) {
                sb.append(i).append('\n');
                N/=i;
            }
        }
        if(N!=1) sb.append(N);
        System.out.println(sb);
    }

    /**
     * 결국 확실한 개선이 되었는데 그 원인을 파악해보고 싶음
     * 1. while문과 for문 위치 변경
     */
}



