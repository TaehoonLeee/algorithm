package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class B1059 {
    static int L;
    static int[] S;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        L = Integer.parseInt(br.readLine());
        S = new int[L+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i = 0;
        while(st.hasMoreTokens()) {
            S[i++] = Integer.parseInt(st.nextToken());
        }
        n = Integer.parseInt(br.readLine());

        int min = 0, max = 10000000;
        boolean luck = false;
        for(i = 0; i < S.length; i++) {
            if(S[i] < n) {
                min = S[i] > min ? S[i] : min;
            }
            else if(S[i] > n) {
                max = S[i] < max ? S[i] : max;
            }
            else if(S[i] == n) luck = true;
        }

        if(luck) bw.write(String.valueOf(0)+"\n");
        else bw.write(String.valueOf((n-min)*(max-n) - 1)+"\n");

        bw.flush();
        bw.close();

    }
}
